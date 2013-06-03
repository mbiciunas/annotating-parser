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

import com.agorex.parse.ParseData;
import com.agorex.parse.search.ResultSetTokenRange;
import com.agorex.parse.search.TokenRange;



/**
 * @author mbiciunas
 *
 */
public final class FindAllLandmarkRange {

   /**
    * Private constructor - all methods are static.
    */
   private FindAllLandmarkRange() {
   }


   /**
    * @param parseData structure containing all parse data.
    * @param tokenRange range of tokens to search.
    * @param landmarkData list of landmarks to search for.
    * @return result set.
    */
   public static ResultSetTokenRange findExclusive(final ParseData parseData, final TokenRange tokenRange, final LandmarkData landmarkData) {
      return find(parseData, tokenRange, landmarkData, true);
   }


   /**
    * @param parseData structure containing all parse data.
    * @param tokenRange range of tokens to search.
    * @param landmarkData list of landmarks to search for.
    * @return result set.
    */
   static ResultSetTokenRange findInclusive(final ParseData parseData, final TokenRange tokenRange, final LandmarkData landmarkData) {
      return find(parseData, tokenRange, landmarkData, false);
   }


   private static ResultSetTokenRange find(final ParseData parseData, final TokenRange tokenRange, final LandmarkData landmarkData, final boolean exclusive) {
      final ResultSetTokenRange resultSetTokenRange = new ResultSetTokenRange(10);
      final ResultSetLandmark resultSetLandmark;
      final int size;
      final int offsetStart;
      final int offsetEnd;
      int tokenStart = tokenRange.getTokenStart();

      offsetStart = exclusive ? +1 : 0;
      offsetEnd = exclusive ? -1 : 0;

      resultSetLandmark = FindAllLandmark.find(parseData, tokenRange, landmarkData);

      resultSetLandmark.sort();

      size = resultSetLandmark.getSize();

      for (int index = 0; index <= size; ++index) {
         resultSetTokenRange.add(resultSetLandmark.getLandmark(index), tokenStart, resultSetLandmark.getToken(index) + offsetEnd);

         tokenStart = resultSetLandmark.getToken(index) + offsetStart;
      }

      if (tokenStart <= tokenRange.getTokenEnd()) {
         resultSetTokenRange.add(tokenStart, tokenRange.getTokenEnd());
      }

      return resultSetTokenRange;
   }
}
