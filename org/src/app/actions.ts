import { actionCreator } from "../../../../ardoq-packages/packages/rxbeach/src";

export const setName = actionCreator<string>(
    '[person] SET_NAME'
)

export const setAge = actionCreator<number>(
    '[person] SET_AGE'
)

export const setColour = actionCreator<string>(
    '[person] SET_COLOUR'
)

export const getColour = actionCreator<void>(
    '[person] GET_COLOUR'
)
