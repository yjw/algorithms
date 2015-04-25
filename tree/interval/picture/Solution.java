public class Solution {
    private static int LEN = 10000;
    Node node [LEN * 4];
    ScanLine scan[LEN];
    int y[LEN];
    public void build (int l, int r, int i) {
        node[i].left = l;
        node[i].right = r;
        node[i].count = 0;
        node[i].m = 0;
        node[i].line = 0;
        if (r - l > 1) {
            int mid = l + (r - l) / 2;
            build(l, mid, 2 * i + 1);
            build(mid, r, 2 * i + 2);
        }
    }
    
    public void update_m(int i) {
        if (node[i].count > 0) {
            node[i].m = y[node[i].right] - y[node[i].left];
        }
        else if (node[i].right - node[i].left == 1) {
            node[i].m = 0;
        }
        else {
            node[i].m = node[2 * i + 1].m + node[2 * i + 2].m;
        }
    }
    
    public void compute () {
        int n;
        scanf("%d", &n);
        int x1, y1, x2, y2;
        int i = 0;
        while (n--) {
            scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
            scan[i].x = x1;
            scan[i].y1 = y1;
            scan[i].y2 = y2;
            scan[i].flag = 1;
            y[i++] = y1;
            scan[i].x = x2;
            scan[i].y1 = y1;
            scan[i].y2 = y2;
            scan[i].flag = 0;
            y[i++] = y2;
        }
        Arrays.sort(y);
        Arrays.sort(scan);
        int unique_count = unique(y, y + i) - y;
        build(0, unique_count - 1, 0);
        
        int perimeter = 0;
        int now_m = 0;
        int now_line = 0;
        
        for (int j = 0; j < i; j++) {
            if (scan[j].flag == 1) {
                insert(scan[j].y1, scan[j].y2, 0);
            }
            else {
                remove(scan[j].y1, scan[j].y2, 0);
            }
            if (j >= 1) {
                perimeter += 2*now_line*(scan[j].x - scan[j-1].x);
            }
            perimeter += abs(node[0].m - now_m);
            now_m = node[0].m;
            now_line = node[0].line;
        }
        printf("%d\n", perimeter);
        return 0;
    }    
}


class Node {
    int left;
    int right;
    int count;
    int line;
    int lbd;
    int rbd;
    int m;
}

class ScanLine {
    int x;
    int y1;
    int y2;
    int flag;
}



/*

void update_line(int i)
{
  if (node[i].count > 0)
  {
    node[i].lbd = 1;
    node[i].rbd = 1;
    node[i].line = 1;
  }
  else if (node[i].right - node[i].left == 1)
  {
    node[i].lbd = 0;
    node[i].rbd = 0;
    node[i].line = 0;
  }
  else
  {
    node[i].lbd = node[2*i + 1].lbd;
    node[i].rbd = node[2*i + 2].rbd;
    node[i].line = node[2*i + 1].line + node[2*i + 2].line - node[2*i + 1].rbd*node[2*i + 2].lbd;
  }
}

void insert(int l, int r, int i)
{
  //在这里要取离散化之前的原值进行比较
  if (y[node[i].left] >= l && y[node[i].right] <= r)
    (node[i].count)++;
  else if (node[i].right - node[i].left == 1)
    return;
  else
  {
    int middle = (node[i].left + node[i].right)/2;
    if (r <= y[middle])
      insert(l, r, 2*i + 1);
    else if (l >= y[middle])
      insert(l, r, 2*i + 2);
    else
    {
      insert(l, y[middle], 2*i + 1);
      insert(y[middle], r, 2*i + 2);
    }
  }
  update_m(i);
  update_line(i);
}

void remove(int l, int r, int i)
{
  ////在这里要取离散化之前的原值进行比较
  if (y[node[i].left] >= l && y[node[i].right] <= r)
    (node[i].count)--;
  else if (node[i].right - node[i].left == 1)
    return;
  else
  {
    int middle = (node[i].left + node[i].right)/2;
    if (r <= y[middle])
      remove(l, r, 2*i + 1);
    else if (l >= y[middle])
      remove(l, r, 2*i + 2);
    else
    {
      remove(l, y[middle], 2*i + 1);
      remove(y[middle], r, 2*i + 2);
    }
  }
  update_m(i);
  update_line(i);
}


bool cmp(struct ScanLine line1, struct ScanLine line2)
{
  if (line1.x == line2.x)
    return line1.flag > line2.flag;
  return (line1.x < line2.x);
}

int main()
{
  int n;
  scanf("%d", &n);
  int x1, y1, x2, y2;
  int i = 0;
  while (n--)
  {
    scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
    scan[i].x = x1;
    scan[i].y1 = y1;
    scan[i].y2 = y2;
    scan[i].flag = 1;
    y[i++] = y1;
    scan[i].x = x2;
    scan[i].y1 = y1;
    scan[i].y2 = y2;
    scan[i].flag = 0;
    y[i++] = y2;
  }
  sort(y, y + i);
  sort(scan, scan + i, cmp);
  //y数组中不重复的个数
  int unique_count = unique(y, y + i) - y;
  //离散化，建立线段树
  build(0, unique_count - 1, 0);
  
  int perimeter = 0;
  int now_m = 0;
  int now_line = 0;
  
  for (int j = 0; j < i; j++)
  {
    if (scan[j].flag)
      insert(scan[j].y1, scan[j].y2, 0);
    else
      remove(scan[j].y1, scan[j].y2, 0);
    if (j >= 1)
      perimeter += 2*now_line*(scan[j].x - scan[j-1].x);
    perimeter += abs(node[0].m - now_m);
    now_m = node[0].m;
    now_line = node[0].line;
  }

  printf("%d\n", perimeter);
  return 0;
}
*/