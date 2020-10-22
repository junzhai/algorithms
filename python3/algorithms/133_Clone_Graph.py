from typing import List
from typing import Optional

from algorithms.common import Node


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None:
            return node
        return self.cloneHelper(node, [None] * 100)

    def cloneHelper(self, node: 'Node', dict: List[Optional['Node']]):
        idx = node.val - 1
        if dict[idx] is not None:
            return dict[idx]

        dict[idx] = Node(node.val)
        for child in node.neighbors:
            dict[idx].neighbors.append(self.cloneHelper(child, dict))

        return dict[idx]
