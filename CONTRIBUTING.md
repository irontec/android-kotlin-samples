## Contributing

First off, thank you for considering contributing to Active Admin. It's people
like you that make Active Admin such a great tool.

### 1. Where do I go from here?

If you've noticed a bug or have a question,
[search the issue tracker](https://github.com/irontec/android-kotlin-samples/issues?q=something)
to see if someone else has already created a ticket.
If not, go ahead and [make one](https://github.com/irontec/android-kotlin-samples/issues/new)!

### 2. Fork & create a branch

If this is something you think you can fix, then
[fork](https://help.github.com/articles/fork-a-repo)
and create a branch with a descriptive name.

A good branch name would be (where issue #7 is the ticket you're working on):

```sh
git checkout -b 7-new-fix-for-fancy-functionality
```

#### 3. Did you find a bug?

* **Ensure the bug was not already reported** by searching on GitHub under [Issues](https://github.com/irontec/android-kotlin-samples/issues).

* If you're unable to find an open issue addressing the problem, [open a new one](https://github.com/irontec/android-kotlin-samples/issues/new). 
Be sure to include a **title and clear description**, as much relevant information as possible, 
and a **code sample** or an **executable test case** demonstrating the expected behavior that is not occurring.

* If possible, use the relevant bug report templates to create the issue. 
Simply copy the content of the appropriate template into a .rb file, make the necessary changes to demonstrate the issue, 
and **paste the content into the issue description**:

### 4. Implement your fix or feature

At this point, you're ready to make your changes! Feel free to ask for help;
everyone is a beginner at first :smile_cat:

### 5. Make a Pull Request

At this point, you should switch back to your master branch and make sure it's
up to date with Active Admin's master branch:

```sh
git remote add upstream git@github.com:irontec/android-kotlin-samples.git
git checkout master
git pull upstream master
```

Then update your feature branch from your local copy of master, and push it!

```sh
git checkout 7-new-fix-for-fancy-functionality
git rebase master
git push --set-upstream origin 7-new-fix-for-fancy-functionality
```

Finally, go to GitHub and
[make a Pull Request](https://help.github.com/articles/creating-a-pull-request)
:D

### 6. Keeping your Pull Request updated

If a maintainer asks you to "rebase" your PR, they're saying that a lot of code
has changed, and that you need to update your branch so it's easier to merge.

To learn more about rebasing in Git, there are a lot of
[good](http://git-scm.com/book/en/Git-Branching-Rebasing)
[resources](https://help.github.com/articles/interactive-rebase),
but here's the suggested workflow:

```sh
git checkout 7-new-fix-for-fancy-functionality
git pull --rebase upstream master
git push --force-with-lease 7-new-fix-for-fancy-functionality
```
