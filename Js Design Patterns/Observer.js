class CustomEvent {
    #events = {};
    #id = 0;
    
    createEvent = (event) => {
        if (!this.#events[event]) {
            this.#events[event] = [];
            return true;
        }

        return false;
    }

    subscribe = (eventName, callback) => {
        if (this.#events[eventName]) {
            this.#events[eventName].push({ id: this.#id++, callback });
            return this.#id - 1;
        }

        throw new Error(`Event ${eventName} does not exist`);
    }

    unsubscribe = (eventName, id) => {
        if (this.#events[eventName]) {
            this.#events[eventName] = this.#events[eventName].filter(event => event.id !== id);
            return id;
        }

        throw new Error( "Could not unsubscribe");
    }

    dispatch = (eventName, data) => {
        if (this.#events[eventName]) {
            for(let event of this.#events[eventName]) {
                event.callback(data);
            }

            return "Event dispatched!";
        }

        throw new Error("Could not dispatch event");
    }

}