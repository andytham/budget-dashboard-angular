import { EVENTS } from './dummy-data';

let gains = [];
for(let event of EVENTS){
	if(event.funds > 0) gains.push(event);
}

export default gains;