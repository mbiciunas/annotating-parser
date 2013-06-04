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


/**
 * @author mbiciunas
 *
 */
public abstract class AbstractData {

   private final transient Data data;


   /**
    *
    */
   protected AbstractData() {
      data = makeData();

      loadToken(data.getToken());
      loadAnnotationState(data.getAnnotationState());
      loadAllBracket(data.getAllBracket());
      loadAllAnnotation(data.getAllAnnotation());
      loadAllLandmark(data.getAllLandmark());
      loadAllLandmarkForward(data.getAllLandmarkForward());
      loadAllLandmarkRange(data.getAllLandmarkRange());
   }


   /**
    * @return object containing statement and correct processing data
    */
   protected abstract Data makeData();


   /**
    * @param dataToken set of tokens for the statement
    */
   protected abstract void loadToken(final DataToken dataToken);


   /**
    * @param dataAnnotationState annotation state for the statement
    */
   protected abstract void loadAnnotationState(final DataAnnotationState dataAnnotationState);


   /**
    * @param dataAllBracket set of brackets that exist for the statement
    */
   protected abstract void loadAllBracket(final DataAllBracket dataAllBracket);


   /**
    * @param dataAllAnnotation set of annotations that exist for the statement
    */
   protected abstract void loadAllAnnotation(final DataAllAnnotation dataAllAnnotation);


   /**
    * @param dataAllLandmark set of landmarks that exist for the statement
    */
   protected abstract void loadAllLandmark(final DataAllLandmark dataAllLandmark);


   /**
    * @param dataAllLandmarkForward set of forward landmarks that exist for the statement
    */
   protected abstract void loadAllLandmarkForward(final DataAllLandmarkForward dataAllLandmarkForward);


   /**
    * @param dataAllLandmarkRange set of landmark ranges that exist for the statement
    */
   protected abstract void loadAllLandmarkRange(final DataAllLandmarkRange dataAllLandmarkRange);


   /**
    * @return object containing statement and correct processing data
    */
   public final Data getData() {
      return data;
   }
}
