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


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author mbiciunas
 *
 */
public final class ResultSingleLandmarkTest {

   private static final char[] LANDMARK = "test".toCharArray();
   private static final int TOKEN = 4;

   private transient ResultSingleLandmark resultSingleLandmark;


   /**
    *
    */
   @Before
   public void setUp() {
      resultSingleLandmark = new ResultSingleLandmark(LANDMARK, TOKEN);
   }


   /**
    *
    */
   @Test
   public void testResultSingleLandmark() {
      assertArrayEquals("Landmark not right", LANDMARK, resultSingleLandmark.getLandmark());
      assertEquals("token not right", TOKEN, resultSingleLandmark.getToken());
   }


   /**
    *
    */
   @Test
   public void testGetLandmark() {
      assertArrayEquals("Landmark not right", LANDMARK, resultSingleLandmark.getLandmark());
   }


   /**
    *
    */
   @Test
   public void testGetToken() {
      assertEquals("token not right", TOKEN, resultSingleLandmark.getToken());
   }
}
