package graph

import java.util.*
import kotlin.collections.ArrayList


fun main() {
    var tree: TreeNode<Int> = TreeNode(0)
    val answer = ArrayList<String>()
    while (true) {
        val (n, m) = readln().split(' ').map { it.toInt() }
        if (n == 0 && m == 0) {
            break
        }
        repeat(m) {
            val (targetValue, destinationValue) = readln().split(' ').map { it.toInt() }
            tree.findNode(targetValue)?.let { target ->
                target.findNode(destinationValue)?.let {
                    tree.children.removeAt(tree.findRootIndex(destinationValue))
                } ?: target.add(TreeNode(destinationValue))
            } ?: tree.findNode(destinationValue)?.let { destination ->
                destination.add(TreeNode(targetValue))
            } ?: tree.children.add(TreeNode(targetValue)).let { tree.connectNode(targetValue, destinationValue) }
            println(tree.children.map { it.value }.toString())
        }
    }
    answer.forEach {
        println(it)
    }
}

class TreeNode<Int>(val value: Int) {
    val children: MutableList<TreeNode<Int>> = mutableListOf()
    private var parent: TreeNode<Int>? = null
    fun add(childNode: TreeNode<Int>): TreeNode<Int> {
        children.add(childNode)
        childNode.setParent(this)
        return this
    }

    fun findRootParent(currentTree: TreeNode<Int>): TreeNode<Int>? {
        println("find")
        if (currentTree.parent?.value == 0) {
            println("find ${currentTree.value}")
            return currentTree
        } else {
            currentTree.parent?.let { findRootParent(it) }
            return null
        }
    }

    private fun setParent(parent: TreeNode<Int>) {
        this.parent = parent
    }

    fun connectNode(targetValue: Int, destinationValue: Int) {
        findNode(targetValue)?.add(TreeNode(destinationValue))
    }

    fun findNode(value: Int): TreeNode<Int>? {
        var result: TreeNode<Int>? = null
        depthFirstTraversal {
            if (it.value == value) {
                result = it
            }
        }
        return result
    }
    fun findRootIndex(value: Int): kotlin.Int {
        children.forEachIndexed { index, treeNode ->
            if(treeNode.findNode(value) != null){
                return index
            }
        }
        return -1
    }

    private fun levelOrderTraversal(visit: (TreeNode<Int>) -> Unit) {
        visit(this)
        val queue: Queue<TreeNode<Int>> = LinkedList()
        children.forEach { queue.offer(it) }
        var node = queue.poll()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.offer(it) }
            node = queue.poll()
        }
    }

    fun depthFirstTraversal(visit: (TreeNode<Int>) -> Unit) {
        visit(this)
        children.forEach {
            it.depthFirstTraversal(visit)
        }
    }
}