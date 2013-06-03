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
package com.agorex.parse.search;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public final class TokenRangeTest {

   private transient TokenRange tokenRange;


   @Before
   public void setUp() {
      tokenRange = new TokenRange();
   }


   @Test
   public void testResultSingleTokenRange() {
      tokenRange = new TokenRange();

      assertEquals("token name not right", null, tokenRange.getName());
      assertEquals("Start token not right", -1, tokenRange.getTokenStart());
      assertEquals("End token not right", -1, tokenRange.getTokenEnd());
      assertEquals("Token width not right", 0, tokenRange.getWidth());
   }


   @Test
   public void testResultSingleTokenRangeIntInt() {
      tokenRange = new TokenRange(3, 7);

      assertEquals("token name not right", null, tokenRange.getName());
      assertEquals("Start token not right", 3, tokenRange.getTokenStart());
      assertEquals("End token not right", 7, tokenRange.getTokenEnd());
      assertEquals("Token width not right", 4, tokenRange.getWidth());
   }


   @Test
   public void testResultSingleTokenRangeStringIntInt() {
      tokenRange = new TokenRange("test", 3, 7);

      assertEquals("token name not right", "test", tokenRange.getName());
      assertEquals("Start token not right", 3, tokenRange.getTokenStart());
      assertEquals("End token not right", 7, tokenRange.getTokenEnd());
      assertEquals("Token width not right", 4, tokenRange.getWidth());
   }


   @Test
   public void testGetName() {
      tokenRange = new TokenRange("test", 3, 7);

      assertEquals("token name not right", "test", tokenRange.getName());
   }


   @Test
   public void testSetName() {
      tokenRange.setName("test");

      assertEquals("token name not right", "test", tokenRange.getName());
   }


   @Test
   public void testGetTokenStart() {
      tokenRange = new TokenRange(3, 7);

      assertEquals("Start token not right", 3, tokenRange.getTokenStart());
   }


   @Test
   public void testSetStart() {
      tokenRange.setStart(3);

      assertEquals("Start token not right", 3, tokenRange.getTokenStart());
   }


   @Test
   public void testGetTokenEnd() {
      tokenRange = new TokenRange(3, 7);

      assertEquals("End token not right", 7, tokenRange.getTokenEnd());
   }


   @Test
   public void testSetEnd() {
      tokenRange.setEnd(7);

      assertEquals("End token not right", 7, tokenRange.getTokenEnd());
   }


   @Test
   public void testGetWidth() {
      tokenRange = new TokenRange(3, 7);

      assertEquals("Token width not right", 4, tokenRange.getWidth());
   }
}
