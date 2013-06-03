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
public final class FindAllLandmarkForward {

   /**
    * Private constructor - all methods are static.
    */
   private FindAllLandmarkForward() {
   }


   /**
    * @param parseData structure containing all parse data
    * @param tokenRange range of tokens to search.
    * @param landmarkData list of landmarks to search for.
    * @return result set.
    */
   public static ResultSetTokenRange findExclusive(final ParseData parseData, final TokenRange tokenRange, final LandmarkData landmarkData) {
      final ResultSetTokenRange resultSetTokenRange = new ResultSetTokenRange(10);
      final ResultSetLandmark resultSetLandmark;
      final int size;
      int index;

      resultSetLandmark = FindAllLandmark.find(parseData, tokenRange, landmarkData);

      resultSetLandmark.sort();

      size = resultSetLandmark.getSize();

      for (index = 0; index <= size; ++index) {
         if (index > 0) {
            resultSetTokenRange.getTokenRange(index - 1).setEnd(resultSetLandmark.getToken(index) - 1);
         }

         resultSetTokenRange.add(resultSetLandmark.getLandmark(index), resultSetLandmark.getToken(index) + 1, 0);
      }

      if (index > 0) {
         resultSetTokenRange.getTokenRange(index - 1).setEnd(tokenRange.getTokenEnd());
      }

      return resultSetTokenRange;
   }
}
