
public class ArrayList<T> implements List<T> {
	private T data[];
	private int length;
	private int sz;
	
	public ArrayList() {
		length = 10;
		data = (T[]) new Object[length];
		sz = 0;
	}

	@Override
	public void add(T item) {
		resize();
		data[sz++] = item;
	}
	
	private void resize() {
		if (sz == length) {
			length *= 2;
			T newData[] = (T[]) new Object[length];
			for (int i = 0; i < sz; i++) {
				newData[i] = data[i];
			}
			data = newData;
		}
	}

	@Override
	public void add(int pos, T item) {
		resize();
		if (pos >= 0 && pos < sz + 1) {
			for (int i = sz; i > pos; i--) {
				data[i] = data[i - 1];
			}
			data[pos] = item;
			sz++;
		}
	}

	@Override
	public T get(int pos) {
		if (pos >= 0 && pos < sz) {
			return data[pos];
		}
		return null;
	}

	@Override
	public T remove(int pos) {
		T d = get(pos);
		if (d != null) {
			for (int i = pos; i < sz - 1; i++) {
				data[i] = data[i + 1];
			}
			sz--;
		}
		return d;
	}

	@Override
	public int size() {
		return sz;
	}
}
