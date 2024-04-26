public final boolean isPackagePrivate() {
    return !isPrivate() && !isPublic() && !isProtected();
}
