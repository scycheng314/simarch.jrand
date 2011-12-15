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

package it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams;

import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.pseudoRandomGenerators.UniformStream;

/** Defines a Discrete Mass Function that is limited (bounded) in its domain.
 *
 * @author gianni
 */
public final class BoundedDiscreteMassFunctionStream implements DiscreteMassFunctionStream {
    
    private Number x[];
    private Double p[];
    
    private UniformStream gen;
    /** Creates a new instance of BoundedDiscreteMassFunctionStream */
    
    public BoundedDiscreteMassFunctionStream(final UniformStream u, final Number iv[], final Double dv[]) {
        
        x = iv;
        p = dv;
        
        gen = u;
    }

    /*
     * Function definition: returns the probability associated to a point in the domain
     */
    public Double getProbabilityFor(final Integer i) {
        for (int j = 0; j < x.length; j++) {
            if (x[j] == i) {
                return p[j];
            }
        }
        
        return 0.0;
    }

    public Number getNext() {
        
        Double d = gen.getNext().doubleValue();
        
        double sum = 0;
                
        //if (p[0] >= d) return x[0];
        
        for (int j = 0; j < x.length; j++) {                           
            sum += p[j];
            if (sum >= d) return x[j];     
        }        
        return x[x.length - 1];
    }

    public void goTo(final long l) {
        gen.goTo(l);
    }
    
}
