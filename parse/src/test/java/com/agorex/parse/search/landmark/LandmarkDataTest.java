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

public final class LandmarkDataTest {

   private static final String LANDMARK_SELECT = "Select";
   private static final String LANDMARK_FROM = "FROM";
   private static final String LANDMARK_WHERE = "where";

   private static final char[] LANDMARK_CHAR_SELECT = "select".toCharArray();
   private static final char[] LANDMARK_CHAR_FROM = "from".toCharArray();
   private static final char[] LANDMARK_CHAR_WHERE = "where".toCharArray();

   private transient LandmarkData landmarkData;


   @Before
   public void setUp() {
      landmarkData = new LandmarkData(2);
   }


   @Test
   public void testLandmarkDataCharArrayArray() {
      landmarkData = new LandmarkData(LANDMARK_CHAR_SELECT, LANDMARK_CHAR_FROM, LANDMARK_CHAR_WHERE);

      assertEquals("Result set not right size", 2, landmarkData.getSize());
      assertArrayEquals("Landmark value", LANDMARK_CHAR_SELECT, landmarkData.getLandmark(0));
      assertArrayEquals("Landmark value", LANDMARK_CHAR_FROM, landmarkData.getLandmark(1));
      assertArrayEquals("Landmark value", LANDMARK_CHAR_WHERE, landmarkData.getLandmark(2));
   }


   @Test
   public void testLandmarkDataInt() {
      landmarkData = new LandmarkData(2);

      landmarkData.add(LANDMARK_SELECT);
      landmarkData.add(LANDMARK_FROM);
      landmarkData.add(LANDMARK_WHERE);

      assertEquals("Size is  not right", 2, landmarkData.getSize());
      assertArrayEquals("Landmark value", LANDMARK_CHAR_SELECT, landmarkData.getLandmark(0));
      assertArrayEquals("Landmark value", LANDMARK_CHAR_FROM, landmarkData.getLandmark(1));
      assertArrayEquals("Landmark value", LANDMARK_CHAR_WHERE, landmarkData.getLandmark(2));
   }


   @Test
   public void testInitialize() {
      landmarkData.add(LANDMARK_SELECT);

      landmarkData.initialize();

      assertEquals("Sizeis  not right", -1, landmarkData.getSize());
   }


   @Test
   public void testGetSize() {
      landmarkData.add(LANDMARK_SELECT);

      assertEquals("Size is  not right", 0, landmarkData.getSize());
   }


   @Test
   public void testAdd() {
      landmarkData.add(LANDMARK_SELECT);
      landmarkData.add(LANDMARK_FROM);
      landmarkData.add(LANDMARK_WHERE);

      assertEquals("Sizeis  not right", 2, landmarkData.getSize());
      assertArrayEquals("Landmark value", LANDMARK_CHAR_SELECT, landmarkData.getLandmark(0));
      assertArrayEquals("Landmark value", LANDMARK_CHAR_FROM, landmarkData.getLandmark(1));
      assertArrayEquals("Landmark value", LANDMARK_CHAR_WHERE, landmarkData.getLandmark(2));
   }


   @Test
   public void testGetLandmark() {
      landmarkData.add(LANDMARK_SELECT);

      assertArrayEquals("Landmark value", LANDMARK_CHAR_SELECT, landmarkData.getLandmark(0));
   }
}
