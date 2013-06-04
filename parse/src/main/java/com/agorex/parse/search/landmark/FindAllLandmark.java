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
package com.agorex.parse.search.landmark;

import java.util.Arrays;

import com.agorex.parse.ParseData;
import com.agorex.parse.annotation.AnnotationState;
import com.agorex.parse.annotation.AnnotationState.BracketState;
import com.agorex.parse.annotation.AnnotationState.QuoteState;
import com.agorex.parse.search.TokenRange;

/**
 * @author mbiciunas
 *
 */
public final class FindAllLandmark {

   /**
    * Private constructor - all methods are static.
    */
   private FindAllLandmark() {
   }


   /**
    * @param parseData structure containing all parse data.
    * @param tokenRange range of tokens to search.
    * @param landmarkData list of landmarks to search for.
    * @return result set.
    */
   public static ResultSetLandmark find(final ParseData parseData, final TokenRange tokenRange, final LandmarkData landmarkData) {
      final ResultSetLandmark resultSetLandmark = new ResultSetLandmark(10);
      final AnnotationState annotationState = parseData.getAnnotationState();
      int tokenCurrent;
      int annotation;

      annotationState.initialize();

      for (tokenCurrent = tokenRange.getTokenStart(); tokenCurrent <= tokenRange.getTokenEnd(); tokenCurrent++) {
         annotation = parseData.getToken().getAnnotation(tokenCurrent);

         if (annotation == 0 && annotationState.getQuoteState() == QuoteState.NONE && annotationState.getBracketDepth() == 0) {
            checkLandmark(parseData, tokenCurrent, landmarkData, resultSetLandmark);
         }
         else if (annotation != 0 && ! annotationState.process(annotation, tokenCurrent, parseData)) {
            break;
         }
      }

      if (annotationState.getBracketState() == BracketState.ERROR) {
         parseData.getError().add("Brackets are not balanced");
      }

      return resultSetLandmark;
   }


   private static void checkLandmark(final ParseData parseData, final int token, final LandmarkData landmarkData, final ResultSetLandmark resultSetLandmark) {
      final char[] tokenValue = parseData.getSource().getTokenLowerCase(parseData.getToken(), token);

      for (int index = 0; index <= landmarkData.getSize(); ++index) {
         if (Arrays.equals(tokenValue, landmarkData.getLandmark(index))) {
            resultSetLandmark.add(landmarkData.getLandmark(index), token);
            break;
         }

      }
   }
}
