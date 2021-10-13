class DLinkedNode {
  constructor(key = 0, value = 0) {
    this.key = key;
    this.value = value;
    this.next = null;
    this.prev = null;
  }
}

class LRUCache {
  constructor(capacity) {
    this.cache = {};
    this.head = new DLinkedNode();
    this.tail = new DLinkedNode();
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.capacity = capacity;
    this.size = 0;
  }

  get(key) {
    if (key in this.cache) {
      const node = this.cache[key];
      this.moveToHead(node);
      return node.value;
    }
    return -1;
  }

  put(key, value) {
    if (key in this.cache) {
      const node = this.cache[key];
      node.value = value;
      this.moveToHead(node);
    } else {
      const node = new DLinkedNode(key, value);
      this.cache[key] = node;
      this.addToHead(node);
      this.size += 1;
      if (this.size > this.capacity) {
        const node = this.removeTail();
        delete this.cache[node.key];
        this.size -= 1;
      }
    }
  }

  moveToHead(node) {
    this.removeNode(node);
    this.addToHead(node);
  }

  removeNode(node) {
    node.next.prev = node.prev;
    node.prev.next = node.next;
  }

  addToHead(node) {
    node.next = this.head.next;
    node.prev = this.head;
    this.head.next.prev = node;
    this.head.next = node;
  }

  removeTail() {
    const node = this.tail.prev;
    this.removeNode(node);
    return node;
  }
}

const lg = t => console.log(t);

cache = new LRUCache(2);
cache.put(1, 1);
cache.put(2, 2);
lg(cache.get(1));
// 返回  1
cache.put(3, 3);
// 该操作会使得密钥 2 作废
lg(cache.get(2));
// 返回 - 1 (未找到)
cache.put(4, 4);
// 该操作会使得密钥 1 作废
lg(cache.get(1));
// 返回 - 1 (未找到)
lg(cache.get(3));
// 返回  3
lg(cache.get(4));
// 返回  4

lg(cache);
