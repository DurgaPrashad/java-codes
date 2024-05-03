public class Solution {
  public int compareVersion(String version1, String version2) {
    String[] version1Parts = version1.split("\\.");
    String[] version2Parts = version2.split("\\.");

    int i = 0;
    while (i < version1Parts.length && i < version2Parts.length) {
      int comparison = Integer.compare(Integer.parseInt(version1Parts[i]), Integer.parseInt(version2Parts[i]));
      if (comparison != 0) {
        return comparison;
      }
      i++;
    }

    // If one version number has more revisions than the other,
    // treat the missing revisions as 0.
    while (i < version1Parts.length) {
      if (Integer.parseInt(version1Parts[i]) > 0) {
        return 1;
      }
      i++;
    }
    while (i < version2Parts.length) {
      if (Integer.parseInt(version2Parts[i]) > 0) {
        return -1;
      }
      i++;
    }

    return 0;
  }
}
