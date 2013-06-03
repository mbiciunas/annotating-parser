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

public final class ConfigurationDataTest {

   private static final char CHARACTER_COLON = ':';
   private static final int ANNOTATION_COLON = 1;
   private static final int ACTION_COLON = 2;

   private transient ConfigurationData configurationData;


   @Before
   public void setUp() {
      configurationData = new ConfigurationData(2);
   }


   @Test
   public void testConfigurationData() {
      configurationData = new ConfigurationData(3);

      assertEquals("Incorrect number of annotations", -1, configurationData.getSize());

      configurationData.add(CHARACTER_COLON, ANNOTATION_COLON, ACTION_COLON);
      configurationData.add(CHARACTER_COLON, ANNOTATION_COLON, ACTION_COLON);
      configurationData.add(CHARACTER_COLON, ANNOTATION_COLON, ACTION_COLON);

      assertEquals("Incorrect number of annotations", 2, configurationData.getSize());
   }


   @Test
   public void testAdd() {
      configurationData.add(CHARACTER_COLON, ANNOTATION_COLON, ACTION_COLON);

      assertEquals("Character value is wrong", 0, configurationData.findCharacter(CHARACTER_COLON));
      assertEquals("Annotation value is wrong", ANNOTATION_COLON, configurationData.getAnnotation(0));
      assertEquals("Action value is wrong", ACTION_COLON, configurationData.getAction(0));
   }


   @Test
   public void testGetAnnotation() {
      configurationData.add(CHARACTER_COLON, ANNOTATION_COLON, ACTION_COLON);

      assertEquals("Annotation value is wrong", ANNOTATION_COLON, configurationData.getAnnotation(0));
   }


   @Test
   public void testGetAnnotationQuoteSingle() {
      assertEquals("Single quote annotation should not be set", -1, configurationData.getAnnotationQuoteSingle());

      configurationData.setAnnotationQuoteSingle(1);

      assertEquals("Single quote annotation value is wrong", 1, configurationData.getAnnotationQuoteSingle());
   }


   @Test
   public void testSetAnnotationQuoteSingle() {
      configurationData.setAnnotationQuoteSingle(2);

      assertEquals("Single quote annotation value is wrong", 2, configurationData.getAnnotationQuoteSingle());
   }


   @Test
   public void testGetAnnotationQuoteDouble() {
      assertEquals("Double quote annotation should not be set", -1, configurationData.getAnnotationQuoteDouble());

      configurationData.setAnnotationQuoteDouble(1);

      assertEquals("Double quote annotation value is wrong", 1, configurationData.getAnnotationQuoteDouble());
   }


   @Test
   public void testSetAnnotationQuoteDouble() {
      configurationData.setAnnotationQuoteDouble(2);

      assertEquals("Double quote annotation value is wrong", 2, configurationData.getAnnotationQuoteDouble());
   }


   @Test
   public void testGetAnnotationBracketOpen() {
      assertEquals("Open bracket annotation should not be set", -1, configurationData.getAnnotationBracketOpen());

      configurationData.setAnnotationBracketOpen(1);

      assertEquals("Open bracket annotation value is wrong", 1, configurationData.getAnnotationBracketOpen());
   }


   @Test
   public void testSetAnnotationBracketOpen() {
      configurationData.setAnnotationBracketOpen(2);

      assertEquals("Open bracket annotation value is wrong", 2, configurationData.getAnnotationBracketOpen());
   }


   @Test
   public void testGetAnnotationBracketClose() {
      assertEquals("Close bracket annotation should not be set", -1, configurationData.getAnnotationBracketClose());

      configurationData.setAnnotationBracketClose(1);

      assertEquals("Close bracket annotation value is wrong", 1, configurationData.getAnnotationBracketClose());
   }


   @Test
   public void testSetAnnotationBracketClose() {
      configurationData.setAnnotationBracketClose(2);

      assertEquals("Close bracket annotation value is wrong", 2, configurationData.getAnnotationBracketClose());
   }


   @Test
   public void testGetAction() {
      configurationData.add(CHARACTER_COLON, ANNOTATION_COLON, ACTION_COLON);

      assertEquals("Action value is wrong", ACTION_COLON, configurationData.getAction(0));
   }


   @Test
   public void testFindCharacter() {
      configurationData.add(CHARACTER_COLON, ANNOTATION_COLON, ACTION_COLON);

      assertEquals("Character value is wrong", 0, configurationData.findCharacter(CHARACTER_COLON));
   }
}
