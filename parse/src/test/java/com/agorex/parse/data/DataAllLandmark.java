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

import com.agorex.parse.search.landmark.LandmarkData;
import com.agorex.parse.search.landmark.ResultSetLandmark;

/**
 * @author mbiciunas
 *
 */
public final class DataAllLandmark {

   private final transient LandmarkData landmarkData = new LandmarkData(10);
   private final transient ResultSetLandmark resultSetLandmark = new ResultSetLandmark(10);

   /**
    * @return all the landmarks
    */
   public LandmarkData getLandmarkData() { return landmarkData; }


   /**
    * @param landmark value of the landmark
    * @param token position of the token
    */
   public void add(final String landmark, final int token) {
      resultSetLandmark.add(landmark, token);
   }


//   /**
//    * @param index position in the result set
//    * @return
//    */
//   public char[] getLandmark(final int index) {
//      return resultSetLandmark.getLandmark(index);
//   }


//   /**
//    * @param index position in the result set
//    * @return
//    */
//   public int getToken(final int index) {
//      return resultSetLandmark.getToken(index);
//   }


   /**
    * @return result set for all the landmarks
    */
   public ResultSetLandmark getResultSetLandmark() {
      return resultSetLandmark;
   }
}
