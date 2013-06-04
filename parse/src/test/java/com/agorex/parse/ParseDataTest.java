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
package com.agorex.parse;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.agorex.parse.annotation.AnnotationState;
import com.agorex.parse.data.sql.ConfigurationSql;
//import com.agorex.parse.data.sql.ConfigurationSql;

/**
 * @author mbiciunas
 *
 */
public final class ParseDataTest {

   private static final String DATA = "This is a test";

   private transient ParseData parseData;


   /**
    *
    */
   @Before
   public void setUp() {
      parseData = new ParseData(ConfigurationSql.getConfiguration());
   }


   /**
    *
    */
   @Test
   public void testParseData() {
      assertEquals("Configuration data is wrong", ConfigurationSql.ANNOTATION_QUOTE_SINGLE, parseData.getConfigurationData().getAnnotationQuoteSingle());
      assertEquals("Error data is wrong", -1, parseData.getError().getSize());
      assertEquals("Error data is wrong", 0, parseData.getSource().getSourceLength());
      assertEquals("Annotation stack data is wrong", AnnotationState.BracketState.CLOSE, parseData.getAnnotationState().getBracketState());
      assertEquals("Error data is wrong", -1, parseData.getToken().getSize());
   }


   /**
    *
    */
   @Test
   public void testInitialize() {
      parseData.initialize(DATA);

      assertEquals("Configuration data is wrong", ConfigurationSql.ANNOTATION_QUOTE_SINGLE, parseData.getConfigurationData().getAnnotationQuoteSingle());
      assertEquals("Error data is wrong", -1, parseData.getError().getSize());
      assertEquals("Error data is wrong", DATA.length(), parseData.getSource().getSourceLength());
      assertEquals("Annotation stack data is wrong", AnnotationState.BracketState.CLOSE, parseData.getAnnotationState().getBracketState());
      assertEquals("Error data is wrong", -1, parseData.getToken().getSize());
   }


   /**
    *
    */
   @Test
   public void testGetSource() {
      parseData.initialize(DATA);

      assertEquals("Source data is wrong", DATA.length(), parseData.getSource().getSourceLength());
   }


   /**
    *
    */
   @Test
   public void testGetToken() {
      parseData.initialize(DATA);

      assertEquals("Error data is wrong", -1, parseData.getToken().getSize());
   }


   /**
    *
    */
   @Test
   public void testGetError() {
      parseData.initialize(DATA);

      assertEquals("Error data is wrong", -1, parseData.getError().getSize());
   }


   /**
       *
       */
      @Test
      public void testGetAnnotationState() {
         parseData.initialize(DATA);

         assertEquals("Annotation stack data is wrong", AnnotationState.BracketState.CLOSE, parseData.getAnnotationState().getBracketState());
      }


   /**
    *
    */
   @Test
   public void testGetConfigurationData() {
      parseData.initialize(DATA);

      assertEquals("Configuration data is wrong", ConfigurationSql.ANNOTATION_QUOTE_SINGLE, parseData.getConfigurationData().getAnnotationQuoteSingle());
   }
}
