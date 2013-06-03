/*
 * Copyright 2013 Mark Biciunas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agorex.parse.annotation;

import com.agorex.parse.ParseData;
import com.agorex.parse.token.ConfigurationData;


/**
 * @author mbiciunas
 *
 */
public final class AnnotationState {

   private transient int[] bracketStackToken;
   private transient int[] bracketStackAnnotation;
   private transient int bracketStackIndex;

   private transient BracketState bracketState = BracketState.CLOSE;
   private transient QuoteState quoteState = QuoteState.NONE;

   private transient int bracketStart = -1;
   private transient int bracketEnd = -1;

   private transient int annotationQuoteSingle;
   private transient int annotationQuoteDouble;
   private transient int annotationBracketOpen;
   private transient int annotationBracketClose;


   /**
    * @author mbiciunas
    *
    */
   public enum BracketState {
      OPEN, CLOSE, ERROR
   }


   /**
    * @author mbiciunas
    *
    */
   public enum QuoteState {
      NONE, SINGLE, DOUBLE
   }


   /**
    * @return the current state of the bracket
    */
   public BracketState getBracketState() { return bracketState; }


   /**
    * @return the current state of the quote.
    */
   public QuoteState getQuoteState() { return quoteState; }


   /**
    * @return index of token for the start of bracket
    */
   public int getBracketStart() { return bracketStart; }


   /**
    * @return index of token for the end of bracket.
    */
   public int getBracketEnd() { return bracketEnd; }


   /**
    * @return number of brackets we entered since initialized.
    */
   public int getBracketDepth() { return bracketStackIndex; }


   /**
    * @param size initial size of internal arrays.
    */
   public AnnotationState(final int size) {
      bracketStackToken = new int[size];
      bracketStackAnnotation = new int[size];
      bracketStackIndex = 0;
   }


   /**
    * @param configurationData object defining how to annotate the source.
    */
   public void initialize(final ConfigurationData configurationData) {
      annotationQuoteSingle = configurationData.getAnnotationQuoteSingle();
      annotationQuoteDouble = configurationData.getAnnotationQuoteDouble();

      annotationBracketOpen = configurationData.getAnnotationBracketOpen();
      annotationBracketClose = configurationData.getAnnotationBracketClose();

      initialize();
   }


   /**
    *
    */
   public void initialize() {
      bracketState = BracketState.CLOSE;
      quoteState = QuoteState.NONE;
      bracketStart = -1;
      bracketEnd = -1;
      bracketStackIndex = 0;
   }


   /**
    * @param annotation value of annotation being processed.
    * @param tokenCurrent index of token being processed.
    * @param parseData structure containing all parse data.
    * @return true if no errors (ie: unclosed brackets) were detected during processing.
    */
   public boolean process(final int annotation, final int tokenCurrent, final ParseData parseData) {
      boolean success = true;

      if (annotation == annotationQuoteSingle) {
         quote(parseData, tokenCurrent, annotationQuoteSingle);
      }
      else if (annotation == annotationQuoteDouble) {
         quote(parseData, tokenCurrent, annotationQuoteDouble);
      }
      else if (annotation == annotationBracketOpen) {
         openBracket(tokenCurrent, annotation);
      }
      else if (annotation == annotationBracketClose) {
         closeBracket(tokenCurrent);

         if (bracketState == BracketState.ERROR) {
            success = false;
         }
      }

      return success;
   }


   private void quote(final ParseData parseData, final int tokenCurrent, final int newQuote) {
      final QuoteState quoteCurrent;
      final QuoteState quoteAlternate;
      final boolean changeQuote;

      if (newQuote == annotationQuoteSingle) {
         quoteCurrent = QuoteState.SINGLE;
         quoteAlternate = QuoteState.DOUBLE;
      }
      else {
         quoteCurrent = QuoteState.DOUBLE;
         quoteAlternate = QuoteState.SINGLE;
      }

      if (quoteAlternate == quoteState) {
         changeQuote = false;
      }
      else if (tokenCurrent == 0) {
         changeQuote = true;
      }
      else if (parseData.getToken().getTokenWidth(tokenCurrent - 1) != 1) {
         changeQuote = true;
      }
      else if (parseData.getSource().getCharacter(parseData.getToken().getStartPointer(tokenCurrent - 1)) == '\\') {
         changeQuote = false;
      }
      else {
         changeQuote = true;
      }

      if (changeQuote) {
         if (quoteState == QuoteState.NONE) {
            quoteState = quoteCurrent;
         }
         else {
            quoteState = QuoteState.NONE;
         }
      }
   }


   private void openBracket(final int tokenCurrent, final int annotation) {
      if (quoteState == QuoteState.NONE) {
         push(tokenCurrent, annotation);

         bracketStart = tokenCurrent + 1;
         bracketEnd = -1;
         bracketState = BracketState.OPEN;
      }
   }


   private void closeBracket(final int tokenCurrent) {
      if (quoteState == QuoteState.NONE) {
         if (bracketStackIndex == 0) {
            bracketState = BracketState.ERROR;
         }
         else {
            if (bracketStackAnnotation[bracketStackIndex - 1] == annotationBracketOpen) {
               bracketStart = bracketStackToken[bracketStackIndex - 1] + 1;
               bracketEnd = tokenCurrent - 1;

               bracketState = BracketState.CLOSE;
            }
            else {
               bracketState = BracketState.ERROR;
            }

            popAnnotation();
         }
      }
   }


   private void push(final int token, final int annotation) {
      bracketStackToken[bracketStackIndex] = token;
      bracketStackAnnotation[bracketStackIndex] = annotation;
      ++bracketStackIndex;
   }


   private void popAnnotation() {
      --bracketStackIndex;
   }
}
