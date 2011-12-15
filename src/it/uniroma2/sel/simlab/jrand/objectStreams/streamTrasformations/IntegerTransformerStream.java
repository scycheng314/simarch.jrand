/*
 * 	Copyright (C) 2005-2011 Department of Enteprise Engineering, University of Rome "Tor Vergata"
 *                              ( http://www.dii.uniroma2.it )
 *
 *      This file is part of SimArch and was developed at the Software Engineering Laboratory
 *      ( http://www.sel.uniroma2.it )
 *
 *      SimArch is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      SimArch is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with SimArch.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package it.uniroma2.sel.simlab.jrand.objectStreams.streamTrasformations;

import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;

/** This class is redundant - there are other two classes doing the same transformation
 *
 * @author gianni
 */
public class IntegerTransformerStream implements NumericStream {
    
    private NumericStream toTransform;
    
    /** Creates a new instance of IntegerTransformerStream */
    public IntegerTransformerStream(final NumericStream toTransform) {
        setToTransform(toTransform);
    }
    
    public Integer getNext() {
        return getToTransform().getNext().intValue();
    }
    
    public void goTo(final long l) {
        getToTransform().goTo(l);
    }        

    public NumericStream getToTransform() {
        return toTransform;
    }

    public void setToTransform(final NumericStream s) {
        toTransform = s;
    }
}
