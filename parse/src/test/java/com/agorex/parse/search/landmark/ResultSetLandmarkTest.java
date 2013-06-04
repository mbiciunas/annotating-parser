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
public final class ResultSetLandmarkTest {

   private static final char[] LANDMARK_SELECT = "select".toCharArray();
   private static final char[] LANDMARK_FROM = "from".toCharArray();
   private static final char[] LANDMARK_WHERE = "where".toCharArray();
   private static final char[] LANDMARK_GROUP_BY = "group".toCharArray();

   private static final int TOKEN_SELECT = 1;
   private static final int TOKEN_FROM = 2;
   private static final int TOKEN_WHERE = 3;
   private static final int TOKEN_GROUP_BY = 4;

   private transient ResultSetLandmark resultSetLandmark;


   /**
    *
    */
   @Before
   public void setUp() {
      resultSetLandmark = new ResultSetLandmark(2);
   }


   /**
    *
    */
   @Test
   public void testResultSetLandmark() {
      resultSetLandmark = new ResultSetLandmark(2);

      assertEquals("Result set should be empty", -1, resultSetLandmark.getSize());
   }


   /**
    *
    */
   @Test
   public void testInitialize() {
      resultSetLandmark.add(LANDMARK_SELECT, TOKEN_SELECT);

      resultSetLandmark.initialize();

      assertEquals("Wrong size", -1, resultSetLandmark.getSize());
   }


   /**
    *
    */
   @Test
   public void testGetSize() {
      resultSetLandmark.add(LANDMARK_SELECT, TOKEN_SELECT);

      assertEquals("Wrong size", 0, resultSetLandmark.getSize());
   }


   /**
    *
    */
   @Test
   public void testGetLandmark() {
      resultSetLandmark.add(LANDMARK_SELECT, TOKEN_SELECT);

      assertArrayEquals("Landmark value is wrong", LANDMARK_SELECT, resultSetLandmark.getLandmark(0));
   }


   /**
    *
    */
   @Test
   public void testGetToken() {
      resultSetLandmark.add(LANDMARK_SELECT, TOKEN_SELECT);

      assertEquals("Token value is wrong", TOKEN_SELECT, resultSetLandmark.getToken(0));
   }


   /**
    *
    */
   @Test
   public void testAdd() {
      resultSetLandmark.add(LANDMARK_SELECT, TOKEN_SELECT);

      assertArrayEquals("Landmark value is wrong", LANDMARK_SELECT, resultSetLandmark.getLandmark(0));
      assertEquals("Token value is wrong", TOKEN_SELECT, resultSetLandmark.getToken(0));
   }


   /**
    *
    */
   @Test
   public void testSort() {
      resultSetLandmark.add(LANDMARK_GROUP_BY, TOKEN_GROUP_BY);
      resultSetLandmark.add(LANDMARK_WHERE, TOKEN_WHERE);
      resultSetLandmark.add(LANDMARK_FROM, TOKEN_FROM);
      resultSetLandmark.add(LANDMARK_SELECT, TOKEN_SELECT);

      resultSetLandmark.sort();

      assertEquals("Token value is wrong", TOKEN_SELECT, resultSetLandmark.getToken(0));
      assertEquals("Token value is wrong", TOKEN_FROM, resultSetLandmark.getToken(1));
      assertEquals("Token value is wrong", TOKEN_WHERE, resultSetLandmark.getToken(2));
      assertEquals("Token value is wrong", TOKEN_GROUP_BY, resultSetLandmark.getToken(3));
   }
}
