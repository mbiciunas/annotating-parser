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


/**
 * @author mbiciunas
 *
 */
final class ResultSingleLandmark {

   private final transient String landmark;
   private final transient int token;


   /**
    * @param landmark value of landmark for this result.
    * @param token value of the token for this result.
    */
   ResultSingleLandmark(final String landmark, final int token) {
      this.landmark = landmark;
      this.token = token;
   }


   /**
    * @return value of landmark for this result.
    */
   public String getLandmark() { return landmark; }


   /**
    * @return value of the token for this result.
    */
   public int getToken() { return token; }
}
