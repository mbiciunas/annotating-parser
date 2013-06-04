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

import org.junit.Before;
import org.junit.Test;

import com.agorex.parse.data.sql.ConfigurationSql;

/**
 * @author mbiciunas
 *
 */
public final class TokenDataTest {

   private static final int ANNOTATION_QUOTE_SINGLE = ConfigurationSql.ANNOTATION_QUOTE_SINGLE;
   private static final int ANNOTATION_QUOTE_DOUBLE = ConfigurationSql.ANNOTATION_QUOTE_DOUBLE;
   private static final int ANNOTATION_BRACKET_OPEN = ConfigurationSql.ANNOTATION_BRACKET_OPEN;
   private static final int ANNOTATION_BRACKET_CLOSE = ConfigurationSql.ANNOTATION_BRACKET_CLOSE;

   private static final int POINTER_QUOTE_SINGLE_START = 1;
   private static final int POINTER_QUOTE_SINGLE_END = 2;
   private static final int POINTER_QUOTE_DOUBLE_START = 3;
   private static final int POINTER_QUOTE_DOUBLE_END = 5;
   private static final int POINTER_BRACKET_OPEN_START = 6;
   private static final int POINTER_BRACKET_OPEN_END = 9;
   private static final int POINTER_BRACKET_CLOSE_START = 10;
   private static final int POINTER_BRACKET_CLOSE_END = 14;

   private transient TokenData tokenData;


   /**
    *
    */
   @Before
   public void setUp() {
      tokenData = new TokenData(3);
   }


   /**
    *
    */
   @Test
   public void testTokenData() {
      tokenData = new TokenData(3);

      assertEquals("Result set not right size", -1, tokenData.getSize());
   }


   /**
    *
    */
   @Test
   public void testInitialize() {
      tokenData.add(POINTER_QUOTE_SINGLE_START, POINTER_QUOTE_SINGLE_END, ANNOTATION_QUOTE_SINGLE);

      tokenData.initialize();

      assertEquals("Result set not right size", -1, tokenData.getSize());
   }


   /**
    *
    */
   @Test
   public void testGetSize() {
      tokenData.add(POINTER_QUOTE_SINGLE_START, POINTER_QUOTE_SINGLE_END, ANNOTATION_QUOTE_SINGLE);

      assertEquals("Result set not right size", 0, tokenData.getSize());
   }


   /**
    *
    */
   @Test
   public void testAdd() {
      tokenData.add(POINTER_QUOTE_SINGLE_START, POINTER_QUOTE_SINGLE_END, ANNOTATION_QUOTE_SINGLE);

      assertEquals("Pointer start value is wrong", POINTER_QUOTE_SINGLE_START, tokenData.getStartPointer(0));
      assertEquals("Pointer end value is wrong", POINTER_QUOTE_SINGLE_END, tokenData.getEndPointer(0));
      assertEquals("Annotation value is wrong", ANNOTATION_QUOTE_SINGLE, tokenData.getAnnotation(0));
   }


   /**
    *
    */
   @Test
   public void testGetStartPointer() {
      tokenData.add(POINTER_QUOTE_SINGLE_START, POINTER_QUOTE_SINGLE_END, ANNOTATION_QUOTE_SINGLE);
      tokenData.add(POINTER_QUOTE_DOUBLE_START, POINTER_QUOTE_DOUBLE_END, ANNOTATION_QUOTE_DOUBLE);
      tokenData.add(POINTER_BRACKET_OPEN_START, POINTER_BRACKET_OPEN_END, ANNOTATION_BRACKET_OPEN);
      tokenData.add(POINTER_BRACKET_CLOSE_START, POINTER_BRACKET_CLOSE_END, ANNOTATION_BRACKET_CLOSE);

      assertEquals("Pointer start value is wrong", POINTER_QUOTE_SINGLE_START, tokenData.getStartPointer(0));
      assertEquals("Pointer start value is wrong", POINTER_QUOTE_DOUBLE_START, tokenData.getStartPointer(1));
      assertEquals("Pointer start value is wrong", POINTER_BRACKET_OPEN_START, tokenData.getStartPointer(2));
      assertEquals("Pointer start value is wrong", POINTER_BRACKET_CLOSE_START, tokenData.getStartPointer(3));
   }


   /**
    *
    */
   @Test
   public void testGetEndPointer() {
      tokenData.add(POINTER_QUOTE_SINGLE_START, POINTER_QUOTE_SINGLE_END, ANNOTATION_QUOTE_SINGLE);
      tokenData.add(POINTER_QUOTE_DOUBLE_START, POINTER_QUOTE_DOUBLE_END, ANNOTATION_QUOTE_DOUBLE);
      tokenData.add(POINTER_BRACKET_OPEN_START, POINTER_BRACKET_OPEN_END, ANNOTATION_BRACKET_OPEN);
      tokenData.add(POINTER_BRACKET_CLOSE_START, POINTER_BRACKET_CLOSE_END, ANNOTATION_BRACKET_CLOSE);

      assertEquals("Pointer end value is wrong", POINTER_QUOTE_SINGLE_END, tokenData.getEndPointer(0));
      assertEquals("Pointer end value is wrong", POINTER_QUOTE_DOUBLE_END, tokenData.getEndPointer(1));
      assertEquals("Pointer end value is wrong", POINTER_BRACKET_OPEN_END, tokenData.getEndPointer(2));
      assertEquals("Pointer end value is wrong", POINTER_BRACKET_CLOSE_END, tokenData.getEndPointer(3));
   }


   /**
    *
    */
   @Test
   public void testGetAnnotation() {
      tokenData.add(POINTER_QUOTE_SINGLE_START, POINTER_QUOTE_SINGLE_END, ANNOTATION_QUOTE_SINGLE);
      tokenData.add(POINTER_QUOTE_DOUBLE_START, POINTER_QUOTE_DOUBLE_END, ANNOTATION_QUOTE_DOUBLE);
      tokenData.add(POINTER_BRACKET_OPEN_START, POINTER_BRACKET_OPEN_END, ANNOTATION_BRACKET_OPEN);
      tokenData.add(POINTER_BRACKET_CLOSE_START, POINTER_BRACKET_CLOSE_END, ANNOTATION_BRACKET_CLOSE);

      assertEquals("Annotation value is wrong", ANNOTATION_QUOTE_SINGLE, tokenData.getAnnotation(0));
      assertEquals("Annotation end value is wrong", ANNOTATION_QUOTE_DOUBLE, tokenData.getAnnotation(1));
      assertEquals("Annotation end value is wrong", ANNOTATION_BRACKET_OPEN, tokenData.getAnnotation(2));
      assertEquals("Annotation end value is wrong", ANNOTATION_BRACKET_CLOSE, tokenData.getAnnotation(3));
   }


   /**
    *
    */
   @Test
   public void testGetTokenWidth() {
      tokenData.add(POINTER_QUOTE_SINGLE_START, POINTER_QUOTE_SINGLE_END, ANNOTATION_QUOTE_SINGLE);
      tokenData.add(POINTER_QUOTE_DOUBLE_START, POINTER_QUOTE_DOUBLE_END, ANNOTATION_QUOTE_DOUBLE);
      tokenData.add(POINTER_BRACKET_OPEN_START, POINTER_BRACKET_OPEN_END, ANNOTATION_BRACKET_OPEN);
      tokenData.add(POINTER_BRACKET_CLOSE_START, POINTER_BRACKET_CLOSE_END, ANNOTATION_BRACKET_CLOSE);

      assertEquals("Token length is wrong", POINTER_QUOTE_SINGLE_END - POINTER_QUOTE_SINGLE_START, tokenData.getTokenWidth(0));
      assertEquals("Token length is wrong", POINTER_QUOTE_DOUBLE_END - POINTER_QUOTE_DOUBLE_START, tokenData.getTokenWidth(1));
      assertEquals("Token length is wrong", POINTER_BRACKET_OPEN_END - POINTER_BRACKET_OPEN_START, tokenData.getTokenWidth(2));
      assertEquals("Token length is wrong", POINTER_BRACKET_CLOSE_END - POINTER_BRACKET_CLOSE_START, tokenData.getTokenWidth(3));
   }
}
