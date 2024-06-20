import { reducedStream, reducer } from '../../../../ardoq-packages/packages/rxbeach/src/index.ts'
import { setAge, setColour, setName } from './actions.ts'
import { operations } from './operations.ts'

export type Person = {
    name: string,
    age: number,
    favColour: string,
}

const defaultState = {
    name: "John",
    age: 30,
    favColour: "Blue"
}

export const person$ = reducedStream(
    'person$',
    defaultState,
    [
        reducer(setName, operations.setName),
        reducer(setAge, operations.setAge),
        reducer(setColour, operations.setColour),
    ]
)
