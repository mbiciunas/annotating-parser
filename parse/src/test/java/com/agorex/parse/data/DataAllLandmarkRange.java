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
package com.agorex.parse.data;

import com.agorex.parse.search.ResultSetTokenRange;
import com.agorex.parse.search.landmark.LandmarkData;
import com.agorex.parse.search.landmark.ResultSetLandmark;

/**
 * @author mbiciunas
 *
 */
public final class DataAllLandmarkRange {

   private final transient LandmarkData landmarkData = new LandmarkData(10);
   private final transient ResultSetLandmark resultSetLandmark = new ResultSetLandmark(10);
   private final transient ResultSetTokenRange resultSetTokenRangeExclusive = new ResultSetTokenRange(10);
   private final transient ResultSetTokenRange resultSetTokenRangeInclusive = new ResultSetTokenRange(10);

   /**
    * @return set of landmarks
    */
   public LandmarkData getLandmarkData() { return landmarkData; }


   /**
    * @param landmark value of the landmark
    * @param minToken value used to start first token range
    * @param token value used to end the first token range and start the second token range
    * @param maxToken value used to end last token range
    */
   public void addFirstAndLast(final String landmark, final int minToken, final int token, final int maxToken) {
      assert minToken <= token : "Minimum token " + minToken + " must be less than or equal to token " + token;
      assert resultSetLandmark.getSize() < 0 : "Must be first landmark added";
      assert token <= maxToken : "Token " + token + " must be less than or equal to maximum token " + maxToken;

      //
      // Add the first landmark.
      //
      addFirst(landmark, minToken, token);

      //
      // Last landmark range being added.
      //
      resultSetTokenRangeExclusive.add(token + 1, maxToken);
      resultSetTokenRangeInclusive.add(token, maxToken);
   }


   /**
    * @param landmark value of the landmark
    * @param minToken value used to start the token range
    * @param token value used to end the token range
    */
   public void addFirst(final String landmark, final int minToken, final int token) {

      assert minToken <= token : "Minimum token " + minToken + " must be less than or equal to token " + token;
      assert resultSetLandmark.getSize() < 0 : "Must be first landmark added";

      resultSetLandmark.add(landmark, token);

      //
      // First annotation being added.
      //
      resultSetTokenRangeExclusive.add(minToken, token - 1);
      resultSetTokenRangeInclusive.add(minToken, token);
   }


   /**
    * @param landmark value of the landmark
    * @param token value used to end the token range
    */
   private void add(final String landmark, final int token) {
      final int previousToken;

      assert resultSetLandmark.getSize() >= 0 : "Must not be the first annotation added";

      //
      // Get the last token added.
      //
      previousToken = resultSetLandmark.getToken(resultSetLandmark.getSize());

      //
      // Add a landmark.
      //
      resultSetLandmark.add(landmark, token);

      //
      // Add landmark range.
      //
      resultSetTokenRangeExclusive.add(previousToken + 1, token - 1);
      resultSetTokenRangeInclusive.add(previousToken, token);
   }


   /**
    * @param landmark value of the landmark
    * @param token value used to start the token range
    * @param maxToken token used to end the token range
    */
   public void addLast(final String landmark, final int token, final int maxToken) {

      assert token <= maxToken : "Token " + token + " must be less than or equal to maximum token " + maxToken;
      assert resultSetLandmark.getSize() >= 0 : "Must not be the first annotation added";

      add(landmark, token);

      //
      // Add last range.
      //
      resultSetTokenRangeExclusive.add(token + 1, maxToken);
      resultSetTokenRangeInclusive.add(token, maxToken);
   }


   /**
    * @return token result set
    */
   public ResultSetTokenRange getResultSetTokenRangeExclusive() {
      return resultSetTokenRangeExclusive;
   }


   /**
    * @return token result set
    */
   public ResultSetTokenRange getResultSetTokenRangeInclusive() {
      return resultSetTokenRangeInclusive;
   }
}
