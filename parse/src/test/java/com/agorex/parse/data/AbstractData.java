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
package com.agorex.parse.data;


public abstract class AbstractData {

   private final transient Data data;


   protected AbstractData() {
      data = makeData();

      loadToken(data.getToken());
      loadAnnotationState(data.getAnnotation());
      loadAllBracket(data.getAllBracket());
      loadAllAnnotation(data.getAllAnnotation());
      loadAllLandmark(data.getAllLandmark());
      loadAllLandmarkForward(data.getAllLandmarkForward());
      loadAllLandmarkRange(data.getAllLandmarkRange());
   }


   protected abstract Data makeData();


   protected abstract void loadToken(final DataToken dataToken);


   protected abstract void loadAnnotationState(final DataAnnotationState dataAnnotationState);


   protected abstract void loadAllBracket(final DataAllBracket dataAllBracket);


   protected abstract void loadAllAnnotation(final DataAllAnnotation dataAllAnnotation);


   protected abstract void loadAllLandmark(final DataAllLandmark dataAllLandmark);


   protected abstract void loadAllLandmarkForward(final DataAllLandmarkForward dataAllLandmarkForward);


   protected abstract void loadAllLandmarkRange(final DataAllLandmarkRange dataAllLandmarkRange);


   public final Data getData() {
      return data;
   }
}
