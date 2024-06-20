import { useState } from 'react';
import * as ReactDOM from 'react-dom/client';
import { action$, dispatchAction, subscribeRoutine } from '../../../ardoq-packages/packages/rxbeach/src';
import { getColour, setAge, setName } from './app/actions';
import Person from './app/Person';
import { routines } from './app/routines';

const Root = () =>  {
  const [newName, setNewName] = useState<string>("");
  const [newAge, setNewAge] = useState<number>(1);
  return (
    <div>
      <Person/>
      <br/>
      <label>Name: </label>
      <input type='text' value={newName} onChange={e => setNewName(e.target.value)}></input>
      <br/>
      <label>Age: </label>
      <input type='number' value={newAge} onChange={e => setNewAge(e.target.valueAsNumber)}></input>
      <br/>
      <button onClick={() => {
        dispatchAction(setName(newName));
        dispatchAction(setAge(newAge));
      }}>Submit</button>
      <br/>
      <br/>
      <button onClick={() => {
        dispatchAction(getColour());
      }}>Assign colour</button>
    </div>)
}

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
subscribeRoutine(action$, routines);
root.render(
  <Root/>
  
);
