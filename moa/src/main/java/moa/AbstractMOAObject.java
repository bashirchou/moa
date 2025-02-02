/*
 *    AbstractMOAObject.java
 *    Copyright (C) 2007 University of Waikato, Hamilton, New Zealand
 *    @author Richard Kirkby (rkirkby@cs.waikato.ac.nz)
 *asasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasas
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program. If not, see <http://www.gnu.org/licenses/>.
 *    
 */
package moa;

import moa.core.SerializeUtils;
import moa.core.SizeOf;

/**
 * Abstract MOA Object. All classes that are serializable, copiable,
 * can measure its size, and can give a description, extend this class.
 *
 * @author Richard Kirkby (rkirkby@cs.waikato.ac.nz)
 * @version $Revision: 7 $
 */
public abstract class AbstractMOAObject implements MOAObject {

    @Override
    public MOAObject copy() {
        return copy(this);
    }

    @Override
    public int measureByteSize() {
        return measureByteSize(this);
    }

    /**
     * Returns a description of the object.
     *
     * @return a description of the object
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        getDescription(sb, 0);
        return sb.toString();
    }

    /**
     * This method produces a copy of an object.
     *
     * @param obj object to copy
     * @return a copy of the object
     */
    public static MOAObject copy(MOAObject obj) {
        try {
            return (MOAObject) SerializeUtils.copyObject(obj);
        } catch (Exception e) {
            throw new RuntimeException("Object copy failed.", e);
        }
    }

    /**
     * Gets the memory size of an object.
     *
     * @param obj object to measure the memory size
     * @return the memory size of this object
     */
    public static int measureByteSize(MOAObject obj) {
        return (int) SizeOf.fullSizeOf(obj);
    }
}
