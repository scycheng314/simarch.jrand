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
import it.uniroma2.sel.simlab.jrand.objectStreams.ObjectStream;
import java.util.ArrayList;
               
/** Defines a stream that results from the shuffling of a set of input streams
 *
 * @author  Daniele Gianni
 */
public class ShuffledStream <T> implements StreamTrasformation <T>{

    // stream used to shuffle the input stream. This stream determines the index of the next
    // object in the Array of objects, to be accessed.
    private NumericStream shuffler;

    // the
    private long size;

    // the list of objects retrieved from the input streams (toShuffle)
    private ArrayList<T> objects;

    // the input streams to shuffle
    private ObjectStream<T> toShuffle;
    
    /** Creates a new instance of ShuffledStream */
    public ShuffledStream(final ObjectStream<T> o, final NumericStream s, final long l) {
        setToShuffle(o);
        setShuffler(s);
        setSize(l);
        init();                        
    }
    
    public T getNext() {
        long toExtract = shuffler.getNext().longValue() % size;
        
        T toReturn = objects.remove((int) toExtract);                         
        objects.add((int) toExtract, toShuffle.getNext());
    
        return toReturn;
    }
        
    public void goTo(final long l) {
        for (long i = 0; i < l; i++) getNext();
    }
    
    private void init() {
        objects = new ArrayList<T>();
        
        for (long l = 0; l < size; l++) {
            objects.add((int) l, toShuffle.getNext());            
        }
    }
    
    private void setSize(final long l) {
        size = l;
    }
    
    private void setShuffler(final NumericStream s) {
        shuffler = s;
    }
    
    private void setToShuffle(final ObjectStream<T> s) {
        toShuffle = s;
    }
}
