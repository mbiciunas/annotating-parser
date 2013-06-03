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
package com.agorex.parse.search.annotation;

import com.agorex.parse.search.TokenRange;
import com.agorex.parse.token.TokenData;


/**
 * @author mbiciunas
 *
 */
final class FindAllAnnotation {

   /**
    * Private constructor - all methods are static.
    */
   private FindAllAnnotation() {
   }


   /**
    * @param tokenData object containing all the tokens for the source.
    * @param tokenRange range of tokens to search.
    * @param annotation value of annotation we are finding.
    * @return result set.
    */
   static ResultSetAnnotation find(final TokenData tokenData, final TokenRange tokenRange, final int annotation) {
      final ResultSetAnnotation tokenAnnotationArray = new ResultSetAnnotation(10);
      final int tokenStart = tokenRange.getTokenStart();
      final int tokenEnd = tokenRange.getTokenEnd();
      int token;

      for (token = tokenStart; token <= tokenEnd; ++token) {
         if (tokenData.getAnnotation(token) == annotation) {
            tokenAnnotationArray.add(annotation, token);
         }
      }

      return tokenAnnotationArray;
   }
}
