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


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author mbiciunas
 *
 */
public final class LandmarkDataTest {

   private static final String LANDMARK_SELECT = "Select";
   private static final String LANDMARK_FROM = "FROM";
   private static final String LANDMARK_WHERE = "where";

   private transient LandmarkData landmarkData;


   /**
    *
    */
   @Before
   public void setUp() {
      landmarkData = new LandmarkData(2);
   }


   /**
    *
    */
   @Test
   public void testLandmarkDataCharArrayArray() {
      landmarkData = new LandmarkData(LANDMARK_SELECT, LANDMARK_FROM, LANDMARK_WHERE);

      assertEquals("Result set not right size", 2, landmarkData.getSize());
      assertEquals("Landmark value", LANDMARK_SELECT, landmarkData.getLandmark(0));
      assertEquals("Landmark value", LANDMARK_FROM, landmarkData.getLandmark(1));
      assertEquals("Landmark value", LANDMARK_WHERE, landmarkData.getLandmark(2));
   }


   /**
    *
    */
   @Test
   public void testLandmarkDataInt() {
      landmarkData = new LandmarkData(2);

      landmarkData.add(LANDMARK_SELECT);
      landmarkData.add(LANDMARK_FROM);
      landmarkData.add(LANDMARK_WHERE);

      assertEquals("Size is not right", 2, landmarkData.getSize());
      assertEquals("Landmark value", LANDMARK_SELECT, landmarkData.getLandmark(0));
      assertEquals("Landmark value", LANDMARK_FROM, landmarkData.getLandmark(1));
      assertEquals("Landmark value", LANDMARK_WHERE, landmarkData.getLandmark(2));
   }


   /**
    *
    */
   @Test
   public void testInitialize() {
      landmarkData.add(LANDMARK_SELECT);

      landmarkData.initialize();

      assertEquals("Sizeis not right", -1, landmarkData.getSize());
   }


   /**
    *
    */
   @Test
   public void testGetSize() {
      landmarkData.add(LANDMARK_SELECT);

      assertEquals("Size is not right", 0, landmarkData.getSize());
   }


   /**
    *
    */
   @Test
   public void testAdd() {
      landmarkData.add(LANDMARK_SELECT);
      landmarkData.add(LANDMARK_FROM);
      landmarkData.add(LANDMARK_WHERE);

      assertEquals("Size is not right", 2, landmarkData.getSize());
      assertEquals("Landmark value", LANDMARK_SELECT, landmarkData.getLandmark(0));
      assertEquals("Landmark value", LANDMARK_FROM, landmarkData.getLandmark(1));
      assertEquals("Landmark value", LANDMARK_WHERE, landmarkData.getLandmark(2));
   }


   /**
    *
    */
   @Test
   public void testGetLandmark() {
      landmarkData.add(LANDMARK_SELECT);

      assertEquals("Landmark value", LANDMARK_SELECT, landmarkData.getLandmark(0));
   }
}
