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
package com.agorex.parse.error;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public final class ErrorDataTest {

   private static final String ERROR_1 = "This is the first error";
   private static final String ERROR_2 = "This is the second error";
   private static final String ERROR_3 = "This is the third error";
   private static final String ERROR_4 = "This is the fourth error";

   private transient ErrorData errorData;

   @Before
   public void setUp() {
      errorData = new ErrorData(3);
   }


   @Test
   public void testErrorData() {
      errorData = new ErrorData(2);

      assertEquals("Result set not right size", -1, errorData.getSize());
   }


   @Test
   public void testInitialize() {
      errorData.add(ERROR_1);

      errorData.initialize();

      assertEquals("Result set not right size", -1, errorData.getSize());
   }


   @Test
   public void testGetSize() {
      errorData.add(ERROR_1);

      assertEquals("Result set not right size", 0, errorData.getSize());
   }


   @Test
   public void testAdd() {
      errorData.add(ERROR_1);

      assertEquals("Did not get value added", ERROR_1, errorData.getError(0));
   }


   @Test
   public void testGetError() {
      errorData.add(ERROR_1);
      errorData.add(ERROR_2);
      errorData.add(ERROR_3);
      errorData.add(ERROR_4);

      assertEquals("Did not get value added", ERROR_1, errorData.getError(0));
      assertEquals("Did not get value added", ERROR_3, errorData.getError(2));
      assertEquals("Did not get value added", ERROR_2, errorData.getError(1));
      assertEquals("Did not get value added", ERROR_4, errorData.getError(3));
   }


   @Test(expected = IllegalArgumentException.class)
   public void testGetErrorInvalid() {
      errorData.getError(0);
   }


   @Test(expected = IllegalArgumentException.class)
   public void testGetErrorNegative() {
      errorData.getError(-1);
   }


   @Test
   public void testIsErrorFree() {
      assertTrue("Error data should be empty", errorData.isErrorFree());

      errorData.add(ERROR_1);

      assertFalse("Error data should not be empty", errorData.isErrorFree());
   }


   @Test
   public void testIsErrors() {
      assertFalse("Error data should be empty", errorData.isErrors());

      errorData.add(ERROR_1);

      assertTrue("Error data should not be empty", errorData.isErrors());
   }
}
