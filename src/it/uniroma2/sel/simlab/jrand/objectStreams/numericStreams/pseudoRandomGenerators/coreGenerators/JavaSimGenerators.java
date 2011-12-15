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

package it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.pseudoRandomGenerators.coreGenerators;

import it.uniroma2.sel.simlab.math.functions.MitraniFunction;
import it.uniroma2.sel.simlab.math.functions.SedgewickFunction;
import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.ValueDependingIterativeStream;
import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.numericStreamTrasformations.LinearTrasformation;
import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.numericStreamTrasformations.ShuffledNumericStream;

/** This class is inspired and built upon JavaSim generators. It restructures ths
 * generator using the jRand conceptual framework.
 * This class is to be used as is - just instante it using and plug it into
 * other pseudorandom generators defined in the father package.
 *
 * @author Daniele Gianni
 */
public class JavaSimGenerators extends ShuffledNumericStream {

    public final static long LC_SEED_DEF = 1878892440;
    public final static long M_SEED_DEF  = 772531;
    
    public final static long SIZE_DEF = 128;
        
    public JavaSimGenerators() {
        super(new LinearTrasformation(new ValueDependingIterativeStream(new MitraniFunction(), 
                                                                        (double)M_SEED_DEF),
                                      1 / (new MitraniFunction()).getMax(), 0),
              new ValueDependingIterativeStream(new SedgewickFunction(), LC_SEED_DEF), SIZE_DEF);        
    }
        
    public JavaSimGenerators(final long l) {
        super(new LinearTrasformation(new ValueDependingIterativeStream(new MitraniFunction(), 
                                                                        (double)M_SEED_DEF),
                                      1 / (new MitraniFunction()).getMax(), 0),
              new ValueDependingIterativeStream(new SedgewickFunction(), LC_SEED_DEF), SIZE_DEF);        
        
        goToObject(l*1000);
    }
    
    public JavaSimGenerators(final long lcSeed, final long mSeed) {
        super(new LinearTrasformation(new ValueDependingIterativeStream(new MitraniFunction(), 
                                                                        (double)mSeed),
                                      1 / (new MitraniFunction()).getMax(), 0),
              new ValueDependingIterativeStream(new SedgewickFunction(), lcSeed), SIZE_DEF);        
    }        
    
    public void goToObject(final long i) {
        for (long j = 0; j < i; j++) {
            getNext();
        }
    }
}
