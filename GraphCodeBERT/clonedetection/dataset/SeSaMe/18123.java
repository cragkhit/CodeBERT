public MediaType withoutParameters() {
    return parameters.isEmpty() ? this : create ( type, subtype );
}
