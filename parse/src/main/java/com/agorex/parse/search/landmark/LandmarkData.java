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

import java.util.Arrays;
import java.util.Locale;

import com.agorex.parse.utility.AbstractResizable;



/**
 * @author mbiciunas
 *
 */
public final class LandmarkData extends AbstractResizable {

   private transient String[] landmarkArray;


   /**
    * @param landmarkArray array of landmarks
    */
   public LandmarkData(final String ... landmarkArray) {
      super(landmarkArray.length);

      this.landmarkArray = landmarkArray.clone();

      setSize(landmarkArray.length - 1);
   }


   /**
    * @param capacity initial number of elements in landmark set
    */
   public LandmarkData(final int capacity) {
      super(capacity);
      landmarkArray = new String[capacity];
   }


   /**
    * @param landmark value to add to list of landmarks
    */
   public void add(final String landmark) {
      increment();

      landmarkArray[super.getSize()] = landmark.toLowerCase(Locale.getDefault());
   }


   /**
    * @param index position of landmark to return
    * @return landmark identified by the index
    */
   String getLandmark(final int index) {
      return landmarkArray[index];
   }


   @Override
   protected void addCapacity(final int newCapacity) {
      landmarkArray = Arrays.copyOf(landmarkArray, newCapacity);
   }
}
