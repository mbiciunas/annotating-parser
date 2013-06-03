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
package com.agorex.parse.search.bracket;

import com.agorex.parse.ParseData;
import com.agorex.parse.annotation.AnnotationState;
import com.agorex.parse.annotation.AnnotationState.BracketState;
import com.agorex.parse.search.ResultSetTokenRange;
import com.agorex.parse.search.TokenRange;

/**
 * @author mbiciunas
 *
 */
public final class FindAllBracket {

   /**
    * Private constructor - all methods are static.
    */
   private FindAllBracket() {
   }


   /**
    * @param parseData structure containing all parse data
    * @param tokenRange range of tokens to search.
    * @return result set.
    */
   public static ResultSetTokenRange findExclusive(final ParseData parseData, final TokenRange tokenRange) {
      final ResultSetTokenRange resultSetTokenRange = new ResultSetTokenRange(10);
      final AnnotationState annotationState = parseData.getStackAnnotation();
      final int bracketClose = parseData.getConfigurationData().getAnnotationBracketClose();
      int tokenCurrent;
      int annotation;

      annotationState.initialize();

      for (tokenCurrent = tokenRange.getTokenStart(); tokenCurrent <= tokenRange.getTokenEnd(); tokenCurrent++) {
         annotation = parseData.getToken().getAnnotation(tokenCurrent);

         if (annotationState.process(annotation, tokenCurrent, parseData)) {
            if (annotation == bracketClose && annotationState.getBracketState() != BracketState.ERROR && annotationState.getBracketDepth() == 0) {
               resultSetTokenRange.add(annotationState.getBracketStart(), annotationState.getBracketEnd());
            }
         }
         else {
            break;
         }
      }

      if (annotationState.getBracketState() == BracketState.ERROR) {
         parseData.getError().add("Brackets are not balanced");
      }

      return resultSetTokenRange;
   }
}
