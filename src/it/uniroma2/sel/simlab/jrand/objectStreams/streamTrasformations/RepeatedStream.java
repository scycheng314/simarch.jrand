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

import it.uniroma2.sel.simlab.jrand.objectStreams.ObjectStream;

/** Defines a stream transformation consisting in the repetition of the objects
 * received from a specified stream, for a given number of times
 *
 * @author  Daniele Gianni
 */
public class RepeatedStream<T> implements StreamTrasformation<T> {

    final static private int FIRST_REPETITION = 0;

    // number of the current repetition of an object from the original stream
    private int currentRepetition;

    // number of repetitions that must be provided for each object from the original stream
    private int numberOfRepetition;    

    // to stream whose objects must be repeated
    private ObjectStream<T> repeatedStream;

    // the object to be repeated
    private T toRepeat;
    
    /** Creates a new instance of RepeatedStream */
    public RepeatedStream(final ObjectStream s, int n) {        
        setRepeatedStream(s);
        setNumberOfRepetition(n);
        
        initRepetition();
    }
    
    private int getActualRepetition() {
        return currentRepetition;
    }
    
    public T getNext() {
        if (getActualRepetition() < getNumberOfRepetition()) {
            currentRepetition++;
        } else {
            toRepeat = repeatedStream.getNext();
            setActualRepetition(FIRST_REPETITION);           
        }
        return toRepeat;
    }
    
    public int getNumberOfRepetition() {
        return numberOfRepetition;
    }
    
    public void goTo(final long l) {
        for (long i = 0; i < l; i++) getNext();
    }

    private void initRepetition() {
        setActualRepetition(FIRST_REPETITION - 1);
        toRepeat = repeatedStream.getNext();
    }
    
    private void setActualRepetition(final int i) {
        currentRepetition = i;
    }
    
    private void setNumberOfRepetition(final int i) {
        numberOfRepetition = i;
    }
    
    private void setRepeatedStream(final ObjectStream s) {
        repeatedStream = s;
    }
}
