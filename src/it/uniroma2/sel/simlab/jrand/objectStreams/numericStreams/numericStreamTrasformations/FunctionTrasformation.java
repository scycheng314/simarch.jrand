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
import it.uniroma2.sel.simlab.math.Function;

/** Defines a Numeric Stream Transformation that applies a Function to the Numbers
 * genrated by a Numeric Stream, to obtain a new Stream
 *
 * @author  Daniele Gianni
 */
public final class FunctionTrasformation extends NumericStreamTrasformation {
    
    private Function function;
    
    /** Creates a new instance of FunctionTrasformation */
    public FunctionTrasformation(final NumericStream s, final Function f) {
        setFunction(f);
        numericStreams.add(s);
    }
    
    /*
    public Number getMax() {
        return new Double(function.getMax());
    }
    */
    
    public Number getNext() {
        return new Double(function.valueAt(getNumericStream().getNext().doubleValue()));
    }
    
    public Function getFunction() {
        return function;
    }
    
    private NumericStream getNumericStream() {
        return numericStreams.get(0);
    }
    
    private void setFunction(final Function f) {
        function = f;
    }
}
