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
package com.agorex.parse.token;

/**
 * @author mbiciunas
 *
 */
public final class ConfigurationData {

   /**
    * Skip over the character.  Used mostly for spaces.
    */
   public static final int ACTION_SKIP = 1;

   /**
    * Annotate the character.
    */
   public static final int ACTION_ANNOTATE = 2;

   private transient int annotationQuoteSingle = -1;
   private transient int annotationQuoteDouble = -1;
   private transient int annotationBracketOpen = -1;
   private transient int annotationBracketClose = -1;

   private final transient char[] character;
   private final transient int[] annotation;
   private final transient int[] action;
   private final transient int capacity;
   private transient int size;


   /**
    * @param capacity initial number of annotations in result set.
    */
   public ConfigurationData(final int capacity) {
      this.capacity = capacity;
      character = new char[capacity];
      annotation = new int[capacity];
      action = new int[capacity];
      size = -1;
   }


   /**
    * @return number of annotations in the configuration.
    */
   public int getSize() {
      return size;
   }


   /**
    * @param character character to match on.
    * @param annotation value of annotation to associate with the character.
    * @param action how the character is to be processed.
    */
   public void add(final char character, final int annotation, final int action) {
      if (size + 1 > capacity) {
         throw new IllegalArgumentException("To many entries.  Maximum capacity is: " + capacity);
      }

      ++size;

      this.character[size] = character;
      this.annotation[size] = annotation;
      this.action[size] = action;
   }


   /**
    * @param index position of annotation to return.
    * @return annotation identified by the index.
    */
   int getAnnotation(final int index) {
      return annotation[index];
   }


   /**
    * @return annotation used to identify a single quote.
    */
   public int getAnnotationQuoteSingle() {
      return annotationQuoteSingle;
   }


   /**
    * @param annotationQuoteSingle annotation used to identify a single quote.
    */
   public void setAnnotationQuoteSingle(final int annotationQuoteSingle) {
      this.annotationQuoteSingle = annotationQuoteSingle;
   }


   /**
    * @return annotation used to identify a double quote.
    */
   public int getAnnotationQuoteDouble() {
      return annotationQuoteDouble;
   }


   /**
    * @param annotationQuoteDouble annotation used to identify a double quote.
    */
   public void setAnnotationQuoteDouble(final int annotationQuoteDouble) {
      this.annotationQuoteDouble = annotationQuoteDouble;
   }


   /**
    * @return annotation used to identify an open bracket.
    */
   public int getAnnotationBracketOpen() {
      return annotationBracketOpen;
   }


   /**
    * @param annotationBracketOpen annotation used to identify an open bracket.
    */
   public void setAnnotationBracketOpen(final int annotationBracketOpen) {
      this.annotationBracketOpen = annotationBracketOpen;
   }


   /**
    * @return annotation used to identify a close bracket.
    */
   public int getAnnotationBracketClose() {
      return annotationBracketClose;
   }


   /**
    * @param annotationBracketClose annotation used to identify a close bracket.
    */
   public void setAnnotationBracketClose(final int annotationBracketClose) {
      this.annotationBracketClose = annotationBracketClose;
   }


   /**
    * @param index position of action to return.
    * @return action identified by the index.
    */
   int getAction(final int index) {
      return action[index];
   }


   /**
    * @param searchCharacter character to match on.
    * @return index of the annotation that matches the character.
    */
   int findCharacter(final char searchCharacter) {
      int index;

      for (index = 0; index <= size; ++index) {
         if (character[index] == searchCharacter) {
            break;
         }
      }

      if (index > size) {
         index = -1;
      }

      return index;
   }
}
