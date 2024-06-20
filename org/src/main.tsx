import { useState } from 'react';
import * as ReactDOM from 'react-dom/client';
import { action$, dispatchAction, subscribeRoutine } from '../../../ardoq-packages/packages/rxbeach/src';

const Root = () =>  {
  const [newName, setNewName] = useState<string>("");
  const [newAge, setNewAge] = useState<number>(1);
  return (
    <div>
      <br/>
      <label>Name: </label>
      <input type='text' value={newName} onChange={e => setNewName(e.target.value)}></input>
      <br/>
      <label>Age: </label>
      <input type='number' value={newAge} onChange={e => setNewAge(e.target.valueAsNumber)}></input>
      <br/>
      <button>Submit</button>
      <br/>
      <br/>
      <button>Assign colour</button>
    </div>)
}

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
// subscribeRoutine(action$, routines);
root.render(
  <Root/>
  
);
