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

package it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.numericStreamTrasformations;

import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;

/** Limits the positive values of a NumericStream
 *
 * @author  Daniele Gianni
 */
public final class MagnitudeBoundedStream extends NumericStreamTrasformation {

    // the max modules that the numeric stream will present
    private double maxMagnitude;
    
    /** Creates a new instance of MagnitudeBoundedStream */
    public MagnitudeBoundedStream(final NumericStream s, final double d) {
        setToTrasform(s);
        setMaxMagnitude(d);
    }
    
    public Number getMax() {
        return new Double(maxMagnitude);
    }
    
    public Number getNext() {
        Number nextNumber = getToTrasform().getNext();
        
        if (nextNumber.doubleValue() <= maxMagnitude) return nextNumber;        
        else return new Double(maxMagnitude);        
    }
    
    private NumericStream getToTrasform() {
        return numericStreams.get(0);
    }
    
    private void setMaxMagnitude(final double d) {
        maxMagnitude = d;
    }
    
    private void setToTrasform(final NumericStream s) {
        numericStreams.add(0, s);
    }
}
