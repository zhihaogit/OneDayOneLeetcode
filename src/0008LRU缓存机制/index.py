'''
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
'''
import collections


class DLinkedNode:
    def __init__(self, key=0, value=0):
        self.value = value
        self.key = key
        self.next = None
        self.prev = None


class LRUCache:

    def __init__(self, capacity):
        self.cache = dict()
        self.head = DLinkedNode()
        self.tail = DLinkedNode()
        self.head.next = self.tail
        self.tail.prev = self.head
        self.capacity = capacity
        self.size = 0

    def get(self, key):
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self.moveToHead(node)
        return node.value

    def put(self, key, value):
        if key not in self.cache:
            node = DLinkedNode(key, value)
            self.cache[key] = node
            self.addToHead(node)
            self.size += 1
            if self.size > self.capacity:
                removed = self.removeTail()
                self.cache.pop(removed.key)
                self.size -= 1
        else:
            node = self.cache[key]
            node.value = value
            self.moveToHead(node)

    def addToHead(self, node):
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node

    def removeNode(self, node):
        node.next.prev = node.prev
        node.prev.next = node.next

    def moveToHead(self, node):
        self.removeNode(node)
        self.addToHead(node)

    def removeTail(self):
        node = self.tail.prev
        self.removeNode(node)
        return node


'''
使用 OrderedDict结构
'''


class OrderedDictLRUCache(collections.OrderedDict):
    def __init__(self, capacity):
        super().__init__()
        self.capacity = capacity

    def get(self, key):
        if key not in self:
            return -1
        self.move_to_end(key)
        return self[key]

    def put(self, key, value):
        if key in self:
            self.move_to_end(key)
        self[key] = value
        if len(self) > self.capacity:
            self.popitem(last=False)


if __name__ == '__main__':
    # cache = LRUCache(2)
    cache = OrderedDictLRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    print (cache.get(1))
    # 返回  1
    cache.put(3, 3)
    # 该操作会使得密钥 2 作废
    # cache.get(2)
    print (cache.get(2))
    # 返回 - 1 (未找到)
    cache.put(4, 4)
    # 该操作会使得密钥 1 作废
    print (cache.get(1))
    # 返回 - 1 (未找到)
    print (cache.get(3))
    # 返回  3
    print (cache.get(4))
    # 返回  4
