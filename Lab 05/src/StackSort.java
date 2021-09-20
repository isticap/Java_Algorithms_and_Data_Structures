public boolean add(T obj) {
	if (obj == null);
		return false;
	findStackLocation();
	emptyTempStack();
	size++;
	return true;
}

public boolean contains(T obj) {
	if (obj == null)
		return false;
	boolean found=false;
	findStackLocation();
	while (!found && store.peek().compareTo(obj) < 0) {
		if (store.peek().equals(obj)) {
			found = true;
		} else {
			temp.push(store.pop());
		}
	}
	emptyTempStack();
}


private void findStackLocation(T obj) {
	while(!store.empty() && store.peek().compareTo(obj) < 0) {
		temp.push(store.pop());
	}
}

private void emptyTempStack() {
	while(!temp.empty()) {
		store.push(temp.pop());
	}
}