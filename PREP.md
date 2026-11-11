**TL;DR**
- Ideal route, and it's a standard git workflow.
- Prepare each old repo in a **throwaway clone**, so your originals stay untouched.
- Moving everything into a `weekNN/` folder *before* merging avoids conflicts on root files like `README.md`.
- Publishing is the very last step.

```
old week1 repo ─clone→ move into week01/ ─┐
                                           ├─ merge → dsa-java (local) → fix packages → [push, when ready]
old week2 repo ─clone→ move into week02/ ─┘
```

**1. Prepare each old repo (shown for week 1)**
```pwsh
git clone <path-to-old-week1-repo> /tmp/week01-prep
cd /tmp/week01-prep
mkdir week01
git ls-tree --name-only HEAD | ForEach-Object { git mv $_ week01/ }
git commit -m "Move week 1 into week01/"
```
Repeat with `week02`. The old repos only appear as local paths, so no remote hosting is involved.

**2. Merge into the new repo**
```bash
mkdir dsa-java && cd dsa-java
git init -b main
git pull /tmp/week01-prep main --allow-unrelated-histories
git pull /tmp/week02-prep main --allow-unrelated-histories
```
- If your old branch is `master`, use that name instead of `main`.
- `git pull <path> <branch>` skips the add-remote and remove-remote steps.
- There should be no conflicts, since each week lives in its own folder.
- Check with `git log --oneline --graph` that the old commits are there.

**3. Fix things as a separate commit**
- Update the `package` line in each file, and imports if they reference old names.
- Add the top-level index `README.md` and a shared `pom.xml` or `build.gradle`.
- Run the tests, then commit. Keeping this separate from the history import makes it easy to see what you changed.

**4. Publish (only when you decide to)**
```bash
git remote add origin <new-empty-repo-url>
git push -u origin main
```
Create the empty repo on your host first, with no README or `.gitignore`, so the push doesn't conflict.

**Gotchas**
- Each old repo's `.gitignore` ends up inside its week folder, where it still works for that folder. Add a root `.gitignore` too for build output like `target/` or `out/`.
- Old commit messages stay as they were, and so do the dates. Only the paths change.
- Don't delete the old repos until the new one builds and tests pass.
```