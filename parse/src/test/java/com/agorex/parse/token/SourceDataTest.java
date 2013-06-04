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
package com.agorex.parse.token;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author mbiciunas
 *
 */
public final class SourceDataTest {

   private static final String SOURCE_STRING_1 = "This is The first Source string";
   private static final int SOURCE_LENGTH_1 = 31;

   private transient SourceData sourceData;


   /**
    *
    */
   @Before
   public void setUp() {
      sourceData = new SourceData();
   }


   /**
    *
    */
   @Test
   public void testInitialize() {
      sourceData.initialize(SOURCE_STRING_1);

      assertEquals("Source strings are not equal", SOURCE_STRING_1, sourceData.getSource(0, SOURCE_LENGTH_1));
   }


   /**
    *
    */
   @Test
   public void testGetSourceLength() {
      sourceData.initialize(SOURCE_STRING_1);

      assertEquals("Source length is wrong", SOURCE_LENGTH_1, sourceData.getSourceLength());
   }


   /**
    *
    */
   @Test
   public void testGetCharacter() {
      sourceData.initialize(SOURCE_STRING_1);

      assertEquals("Source character is wrong", "i", String.valueOf(sourceData.getCharacter(5)));
   }


   /**
    *
    */
   @Test
   public void testGetSource() {
      sourceData.initialize(SOURCE_STRING_1);

      assertEquals("Source strings are not equal", SOURCE_STRING_1, sourceData.getSource(0, SOURCE_LENGTH_1));
   }


   /**
    *
    */
   @Test
   public void testGetToken() {
      final TokenData tokenData = new TokenData(3);

      sourceData.initialize(SOURCE_STRING_1);

      tokenData.add(0, 4, 0);
      tokenData.add(5, 7, 0);
      tokenData.add(8, 11, 0);

      assertEquals("Token value is wrong", SOURCE_STRING_1.substring(0, 4), sourceData.getToken(tokenData, 0));
      assertEquals("Token value is wrong", SOURCE_STRING_1.substring(5, 7), sourceData.getToken(tokenData, 1));
      assertEquals("Token value is wrong", SOURCE_STRING_1.substring(8, 11), sourceData.getToken(tokenData, 2));
   }


   /**
    *
    */
   @Test
   public void testGetTokenLowerCase() {
      final TokenData tokenData = new TokenData(3);

      sourceData.initialize(SOURCE_STRING_1);

      tokenData.add(0, 4, 0);
      tokenData.add(5, 7, 0);
      tokenData.add(8, 11, 0);

      assertEquals("Token value is wrong", SOURCE_STRING_1.substring(0, 4).toLowerCase(), String.valueOf(sourceData.getTokenLowerCase(tokenData, 0)));
      assertEquals("Token value is wrong", SOURCE_STRING_1.substring(5, 7).toLowerCase(), String.valueOf(sourceData.getTokenLowerCase(tokenData, 1)));
      assertEquals("Token value is wrong", SOURCE_STRING_1.substring(8, 11).toLowerCase(), String.valueOf(sourceData.getTokenLowerCase(tokenData, 2)));
   }


   /**
    *
    */
   @Test
   public void testCompareLowerCase() {
      final TokenData tokenData = new TokenData(3);

      sourceData.initialize(SOURCE_STRING_1);

      tokenData.add(0, 4, 0);
      tokenData.add(5, 7, 0);
      tokenData.add(8, 11, 0);

      assertTrue("Token value is wrong", sourceData.compareLowerCase(tokenData, 0, SOURCE_STRING_1.substring(0, 4).toLowerCase().toCharArray()));
      assertTrue("Token value is wrong", sourceData.compareLowerCase(tokenData, 1, SOURCE_STRING_1.substring(5, 7).toLowerCase().toCharArray()));
      assertTrue("Token value is wrong", sourceData.compareLowerCase(tokenData, 2, SOURCE_STRING_1.substring(8, 11).toLowerCase().toCharArray()));
   }

}
