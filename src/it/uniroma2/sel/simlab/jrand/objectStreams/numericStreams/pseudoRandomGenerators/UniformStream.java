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

package it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.pseudoRandomGenerators;

import it.uniroma2.sel.simlab.math.functions.cumulativeFunctions.UniformCumulativeFunction;
import it.uniroma2.sel.simlab.math.functions.densityFunctions.UniformDensityFunction;

import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;

/** Defines a numeric stream that presents uniform pseudorandom properties
 *
 * @author  Daniele Gianni
 */
public final class UniformStream extends PseudoRandomGenerator {

    // min value of this stream
    private double lowerBound;

    // max value of this stream
    private double upperBound;
            
    /** Creates a new instance of UniformStream */
    public UniformStream(final NumericStream s, final double a, final double b) {
        super(s);        
        
        setLowerBound(a);
        setUpperBound(b);
        
        setCumulativeFunction();
        setDensityFunction();
    }
    
    protected void setCumulativeFunction() {
        cumulativeFunction = new UniformCumulativeFunction(lowerBound, upperBound);
    }
    
    protected void setDensityFunction() {
        densityFunction = new UniformDensityFunction(lowerBound, upperBound);        
    }    
    
    private void setLowerBound(final double d) {
        lowerBound = d;
    }
    
    private void setUpperBound(final double d) {
        upperBound = d;
    }
    
    public Number getNext() {
        Number y = super.getNext();
        
        Double d = new Double(cumulativeFunction.xValueOf(y.doubleValue()));
        
        return d;                        
    }
}
