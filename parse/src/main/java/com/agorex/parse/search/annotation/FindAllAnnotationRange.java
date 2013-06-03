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

import com.agorex.parse.search.ResultSetTokenRange;
import com.agorex.parse.search.TokenRange;
import com.agorex.parse.token.TokenData;



/**
 * @author mbiciunas
 *
 */
public final class FindAllAnnotationRange {

   /**
    * Private constructor - all methods are static.
    */
   private FindAllAnnotationRange() {
   }


   /**
    * @param tokenData object containing all the tokens for the source.
    * @param tokenRange range of tokens to search.
    * @param annotation value of annotation we are finding.
    * @return result set.
    */
   public static ResultSetTokenRange findExclusive(final TokenData tokenData, final TokenRange tokenRange, final int annotation) {
      return find(tokenData, tokenRange, annotation, true);
   }


   /**
    * @param tokenData object containing all the tokens for the source.
    * @param tokenRange range of tokens to search.
    * @param annotation value of annotation we are finding.
    * @return result set.
    */
   static ResultSetTokenRange findInclusive(final TokenData tokenData, final TokenRange tokenRange, final int annotation) {
      return find(tokenData, tokenRange, annotation, false);
   }


   private static ResultSetTokenRange find(final TokenData tokenData, final TokenRange tokenRange, final int annotation, final boolean exclusive) {
      final ResultSetAnnotation resultSetAnnotation;
      final ResultSetTokenRange resultSetTokenRange = new ResultSetTokenRange(10);
      final int offsetStart;
      final int offsetEnd;
      final int size;
      int tokenStart = tokenRange.getTokenStart();

      offsetStart = exclusive ? +1 : 0;
      offsetEnd = exclusive ? -1 : 0;

      resultSetAnnotation = FindAllAnnotation.find(tokenData, tokenRange, annotation);

      size = resultSetAnnotation.getSize();

      for (int index = 0; index <= size; ++index) {
         resultSetTokenRange.add(resultSetAnnotation.getAnnotation(index), tokenStart, resultSetAnnotation.getToken(index) + offsetEnd);

         tokenStart = resultSetAnnotation.getToken(index) + offsetStart;
      }

      if (size >= 0 && tokenStart <= tokenRange.getTokenEnd()) {
         resultSetTokenRange.add(tokenStart, tokenRange.getTokenEnd());
      }

      return resultSetTokenRange;
   }
}
