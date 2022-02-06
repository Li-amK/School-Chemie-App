package gnu.kawa.util;

import java.util.Map;

/* loaded from: classes.dex */
public class GeneralHashTable<K, V> extends AbstractHashTable<HashNode<K, V>, K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // gnu.kawa.util.AbstractHashTable
    public /* bridge */ /* synthetic */ int getEntryHashCode(Map.Entry x0) {
        return getEntryHashCode((HashNode) ((HashNode) x0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // gnu.kawa.util.AbstractHashTable
    public /* bridge */ /* synthetic */ Map.Entry getEntryNext(Map.Entry x0) {
        return getEntryNext((HashNode) ((HashNode) x0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // gnu.kawa.util.AbstractHashTable
    public /* bridge */ /* synthetic */ void setEntryNext(Map.Entry x0, Map.Entry x1) {
        setEntryNext((HashNode) ((HashNode) x0), (HashNode) ((HashNode) x1));
    }

    public GeneralHashTable() {
    }

    public GeneralHashTable(int capacity) {
        super(capacity);
    }

    protected int getEntryHashCode(HashNode<K, V> entry) {
        return entry.hash;
    }

    protected HashNode<K, V> getEntryNext(HashNode<K, V> entry) {
        return entry.next;
    }

    protected void setEntryNext(HashNode<K, V> entry, HashNode<K, V> next) {
        entry.next = next;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // gnu.kawa.util.AbstractHashTable
    public HashNode<K, V>[] allocEntries(int n) {
        return new HashNode[n];
    }

    @Override // gnu.kawa.util.AbstractHashTable
    protected HashNode<K, V> makeEntry(K key, int hash, V value) {
        HashNode<K, V> node = new HashNode<>(key, value);
        node.hash = hash;
        return node;
    }

    @Override // gnu.kawa.util.AbstractHashTable
    public HashNode<K, V> getNode(Object key) {
        return (HashNode) super.getNode(key);
    }
}
