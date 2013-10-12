/*
 * Copyright 2013 Centro de Investigación en Tecnoloxías da Información (CITIUS), University of Santiago de Compostela (USC).
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package es.usc.citius.lab.hipster.algorithm.problem;

import es.usc.citius.lab.hipster.function.CostFunction;
import es.usc.citius.lab.hipster.function.TransitionFunction;
import es.usc.citius.lab.hipster.function.impl.BinaryOperation;

/**
 * Interface that represents a problem to solve. It defines the initial state,
 * the goal state (if required), the {@link TransitionFunction} used to calculate the
 * available movements from one state, the {@link CostFunction} to calculate the
 * cost of a transition, and the {@link BinaryOperation} used to accumulate the costs.
 *
 * @author Pablo Rodríguez Mier
 */
public interface SearchProblem<S, T extends Comparable<T>> {

    /**
     * Initial state (state used to start the search)
     * @return the initial state
     */
    S getInitialState();

    /**
     * Goal state. If there are no goals, just return null.
     * @return goal state (if any) or null.
     */
    S getGoalState();

    /**
     * Transition function used to compute the neighbors of any
     * state.
     * @return transition function
     */
    TransitionFunction<S> getTransitionFunction();

    /**
     * Cost function used to evaluate the cost of a transition
     * @return cost function used to evaluate transitions
     */
    CostFunction<S, T> getCostFunction();

    /**
     * Accumulator function used to
     * @return {@link BinaryOperation} used to accumulate the costs. For working
     * with double numbers as costs, just return a {@link BinaryOperation#doubleAdditionOp()}
     * TODO: Revise if this function can be moved to a different place
     */
    BinaryOperation<T> getAccumulator();

}