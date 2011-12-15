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

import it.uniroma2.sel.simlab.math.functions.CumulativeFunction;
import it.uniroma2.sel.simlab.math.functions.DensityFunction;

import it.uniroma2.sel.simlab.math.Function;
import it.uniroma2.sel.simlab.math.functions.InvertibleFunction;

import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;

import it.uniroma2.sel.simlab.jrand.objectStreams.RandomStream;

/** Defines the skelethon for numeric stream presenting pseudorandom properties
 *
 * @author  Daniele Gianni
 */
public abstract class PseudoRandomGenerator implements NumericStream, RandomStream<Number> {

    /* The probability density function associated to the stream
     *
     */
    protected DensityFunction densityFunction;

    /*
     * The probability cumulative function associated to the stream
     */
    protected CumulativeFunction cumulativeFunction;

    /*
     * The numeric stream used as base to obtain the pseudorandom generator
     */
    private NumericStream core;    
    
    /** Creates a new instance of PseudoRandomGenerator */
    public PseudoRandomGenerator(final NumericStream s) {
        setCore(s);        
    }
    
    public NumericStream getCore() {
        return core;
    }
    
    public InvertibleFunction getCumulativeFunction() {
        return cumulativeFunction;
    }
    
    public Function getDensityFunction() {
        return densityFunction;
    }
    
    public Number getNext() {
        return core.getNext();
    }    
       
    public void setCore(final NumericStream s) {
        core = s;
    }
    
    protected abstract void setCumulativeFunction();
    
    protected abstract void setDensityFunction();
    
    public Number getMax() {
        return new Double(-1);
    }
    
    public void goTo(final long l) {
        for (long i = 0; i < l ; i++) {
            core.getNext();
        }
    }    
}
